package fr.wayUp.cleanArchitecture_demo.web.controller;


import fr.wayUp.cleanArchitecture_demo.application.service.MedicationService;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.MedicationMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.MedicationDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medications")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class MedicationController {

    private final MedicationService medicationService;

    @GetMapping
    public ResponseEntity<List<MedicationDTO>> getAllMedications() {
        List<MedicationDTO> medications = medicationService.getAll()
                .stream()
                .map(MedicationMapper::toDTO)
                .toList();
        return ResponseEntity.ok(medications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDTO> getMedicationById(@PathVariable String id) {
        Optional<MedicationDTO> medication = medicationService.getById(id)
                .map(MedicationMapper::toDTO);
        return medication.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MedicationDTO> createMedication(@RequestBody @Valid MedicationDTO medicationDTO) {
        MedicationDTO createdMedication = MedicationMapper.toDTO(
                medicationService.create(MedicationMapper.toDomain(medicationDTO))
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationDTO> updateMedication(
            @PathVariable String id,
            @RequestBody @Valid  MedicationDTO medicationDTO) {
        medicationDTO.setId(id); // Ensure ID consistency
        MedicationDTO updatedMedication = MedicationMapper.toDTO(
                medicationService.update(MedicationMapper.toDomain(medicationDTO))
        );
        return ResponseEntity.ok(updatedMedication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable String id) {
        medicationService.delete(id);
        return ResponseEntity.noContent().build();
    }
/*
    @GetMapping("/by-prescription/{prescriptionDetailId}")
    public ResponseEntity<List<MedicationDTO>> getMedicationsByPrescription(
            @PathVariable String prescriptionDetailId) {
        List<MedicationDTO> medications = medicationService.getByPrescriptionDetailId(prescriptionDetailId)
                .stream()
                .map(MedicationMapper::toDTO)
                .toList();
        return ResponseEntity.ok(medications);
    }
*/
}
