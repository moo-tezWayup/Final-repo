package fr.wayUp.cleanArchitecture_demo.web.controller;


import fr.wayUp.cleanArchitecture_demo.application.service.FileUploadService;
import fr.wayUp.cleanArchitecture_demo.application.service.PatientService;
import fr.wayUp.cleanArchitecture_demo.domain.model.Patient;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PatientMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PatientDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class PatientController {
    private final PatientService patientService;
    private final FileUploadService fileUploadService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {

        List<PatientDTO> patientDTOS = patientService.getListPatients()
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
        List<PatientDTO> patientsWithFullUrls = fileUploadService.convertToDtoWithFullUrl(patientDTOS);
        return ResponseEntity.ok(patientsWithFullUrls);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable String id) {
        Patient patient = patientService.getPatientById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id: " + id));
        PatientDTO patientDTO = PatientMapper.toDTO(patient);
        PatientDTO patientWithFullUrl = fileUploadService.convertSingleWithFullUrl(patientDTO);
        return ResponseEntity.ok(patientWithFullUrl);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createPatient(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @Valid @ModelAttribute PatientDTO patientDTO) {

        try {
            if (file != null && !file.isEmpty()) {
                String contentType = file.getContentType();
                if (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType)) {
                    return ResponseEntity.badRequest().body("Only JPEG or PNG images are allowed");
                }
            }

            Patient savedPatient = patientService.savePatient(PatientMapper.toDomain(patientDTO));

            if (file != null && !file.isEmpty()) {
                String fileName = fileUploadService.saveImage(file, savedPatient.getId(), "patients");
                savedPatient.setImageDir(fileName);
                savedPatient = patientService.savePatient(savedPatient);
            }

            return ResponseEntity.ok(savedPatient);

        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Error processing file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error creating patient: " + e.getMessage());
        }
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<?> updatePatient(
            @PathVariable String id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @Valid @ModelAttribute PatientDTO patientDTO) {

        try {
            Patient existingPatient = patientService.getPatientById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id: " + id));

            if (file != null && !file.isEmpty()) {
                String contentType = file.getContentType();
                if  (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType)) {
                    return ResponseEntity.badRequest().body("Only JPEG or PNG images are allowed");
                }

                if (existingPatient.getImageDir() != null && !existingPatient.getImageDir().isEmpty()) {
                    fileUploadService.deleteImage(existingPatient.getImageDir());
                }

                String fileName = fileUploadService.saveImage(file, existingPatient.getId(), "patients");
                existingPatient.setImageDir(fileName);
            }

            Patient updatedPatient = patientService.update(patientDTO, existingPatient);
            return ResponseEntity.ok(updatedPatient);

        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Error processing file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error updating patient: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id) {
        Patient patient = patientService.getPatientById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id: " + id));

        if (patient.getImageDir() != null && !patient.getImageDir().isEmpty()) {
            fileUploadService.deleteImage(patient.getImageDir());
        }

        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}