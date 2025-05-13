package fr.wayUp.cleanArchitecture_demo.web.controller;

import fr.wayUp.cleanArchitecture_demo.application.service.ClinicService;
import fr.wayUp.cleanArchitecture_demo.application.service.FileUploadService;
import fr.wayUp.cleanArchitecture_demo.domain.model.Clinic;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ClinicMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ClinicDTO;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/clinics")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClinicController {
    private final ClinicService  clinicService;
    private final FileUploadService fileUploadService ;
    @GetMapping
    public ResponseEntity<List<ClinicDTO>> getAllClinic() {
        List<ClinicDTO> clinicDTOS = clinicService.findAllClinics()
                .stream()
                .map(ClinicMapper::toDTO)
                .toList();
        List<ClinicDTO> clinicWithFullUrls = fileUploadService.convertToDtoWithFullUrl(clinicDTOS);
        return ResponseEntity.ok(clinicWithFullUrls);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ClinicDTO> getClinicById(@PathVariable String id) {
        Clinic clinic = clinicService.getClinicById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clinic not found with id: " + id));

        ClinicDTO clinicDTO = ClinicMapper.toDTO(clinic);
        ClinicDTO clinicWithFullUrl = fileUploadService.convertSingleWithFullUrl(clinicDTO);

        return ResponseEntity.ok(clinicWithFullUrl);
    }


    @PostMapping(value = "/addClinic", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<?> createClinc(
            @RequestParam(value = "file",required = false) MultipartFile file,
            @Valid @ModelAttribute ClinicDTO clinicDTO) {

        try {
            if (file != null && !file.isEmpty()) {
                String contentType = file.getContentType();
                if (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType))
                    return ResponseEntity.badRequest().body("Only JPEG or PNG images are allowed");

            }

            Clinic savedClinc = clinicService.saveClinic(ClinicMapper.toDomain(clinicDTO));

            if (file != null && !file.isEmpty()) {
                String fileName = fileUploadService.saveImage(file, savedClinc.getId(), "clinics");
                savedClinc.setImageDir(fileName);
               savedClinc = clinicService.saveClinic(savedClinc);
            }

            return ResponseEntity.ok(savedClinc);

        } catch (IOException e) {

            return ResponseEntity.internalServerError()
                    .body("Error processing file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error creating clinic : " + e.getMessage());
        }
    }
    @PatchMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<?> patchClinic(
            @PathVariable("id") String id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @ModelAttribute @Valid ClinicDTO clinicDTO) {

        try {
            Optional<Clinic> existingClinicOpt = clinicService.getClinicById(id);
            if (existingClinicOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Clinic existingClinic = existingClinicOpt.get();


            if (file != null && !file.isEmpty()) {
                String contentType = file.getContentType();
                if (contentType == null || (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType))) {
                    return ResponseEntity.badRequest().body("Only JPEG or PNG images are allowed");
                }

                if (existingClinic.getImageDir() != null && !existingClinic.getImageDir().isEmpty()) {
                    fileUploadService.deleteImage(existingClinic.getImageDir());
                }

                String fileName = fileUploadService.saveImage(file, existingClinic.getId(), "clinics");
                existingClinic.setImageDir(fileName);
            }


            Clinic updatedClinic = clinicService.updateClinic(clinicDTO,existingClinic);
            updatedClinic = clinicService.saveClinic(updatedClinic);

            return ResponseEntity.ok(updatedClinic);

        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Error processing file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error updating clinic: " + e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinic(@PathVariable String id) {
        clinicService.deleteClinic(id);
        return ResponseEntity.noContent().build();
    }

}