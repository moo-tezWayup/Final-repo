package fr.wayUp.cleanArchitecture_demo.web.controller;

import fr.wayUp.cleanArchitecture_demo.application.service.PrescriptionService;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PrescriptionMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PrescriptionDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<PrescriptionDTO> createPrescription(@RequestBody @Valid PrescriptionDTO prescriptionDTO) {
        PrescriptionDTO createdPrescription = PrescriptionMapper.toDTO(
                prescriptionService.create(PrescriptionMapper.toDomain(prescriptionDTO))
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPrescription);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> getPrescriptionById(@PathVariable String id) {
        return prescriptionService.getById(id)
                .map(PrescriptionMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionDTO>> getAllPrescriptions() {
        List<PrescriptionDTO> prescriptions = prescriptionService.getAll()
                .stream()
                .map(PrescriptionMapper::toDTO)
                .toList();
        return ResponseEntity.ok(prescriptions);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PrescriptionDTO> updatePrescription(
            @PathVariable String id,
            @RequestBody PrescriptionDTO prescriptionDTO) {
        prescriptionDTO.setId(id);
        PrescriptionDTO updatedPrescription = PrescriptionMapper.toDTO(
                prescriptionService.update(PrescriptionMapper.toDomain(prescriptionDTO))
        );
        return ResponseEntity.ok(updatedPrescription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable String id) {
        prescriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-consultation/{consultationId}")
    public ResponseEntity<List<PrescriptionDTO>> getPrescriptionsByConsultation(
            @PathVariable String consultationId) {
        List<PrescriptionDTO> prescriptions = prescriptionService.getByConsultationId(consultationId)
                .stream()
                .map(PrescriptionMapper::toDTO)
                .toList();
        return ResponseEntity.ok(prescriptions);
    }
}