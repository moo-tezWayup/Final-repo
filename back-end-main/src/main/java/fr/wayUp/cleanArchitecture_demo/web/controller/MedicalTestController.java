package fr.wayUp.cleanArchitecture_demo.web.controller;

import fr.wayUp.cleanArchitecture_demo.application.service.MedicalTestService;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.MedicalTestMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.MedicalTestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medical-tests")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class MedicalTestController {

    private final MedicalTestService medicalTestService;

    @GetMapping
    public ResponseEntity<List<MedicalTestDTO>> getAllMedicalTests() {
        List<MedicalTestDTO> tests = medicalTestService.getAll()
                .stream()
                .map(MedicalTestMapper::toDTO)
                .toList();
        return ResponseEntity.ok(tests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalTestDTO> getMedicalTestById(@PathVariable String id) {
        Optional<MedicalTestDTO> test = medicalTestService.getById(id)
                .map(MedicalTestMapper::toDTO);
        return test.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MedicalTestDTO> createMedicalTest(@RequestBody @Valid MedicalTestDTO medicalTestDTO) {
        MedicalTestDTO createdTest = MedicalTestMapper.toDTO(
                medicalTestService.create(MedicalTestMapper.toDomain(medicalTestDTO))
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalTestDTO> updateMedicalTest(
            @PathVariable String id,
            @RequestBody @Valid MedicalTestDTO medicalTestDTO) {
        medicalTestDTO.setId(id);
        MedicalTestDTO updatedTest = MedicalTestMapper.toDTO(
                medicalTestService.update(MedicalTestMapper.toDomain(medicalTestDTO))
        );
        return ResponseEntity.ok(updatedTest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalTest(@PathVariable String id) {
        medicalTestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}