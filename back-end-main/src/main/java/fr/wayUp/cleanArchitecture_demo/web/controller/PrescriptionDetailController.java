package fr.wayUp.cleanArchitecture_demo.web.controller;



import fr.wayUp.cleanArchitecture_demo.application.service.PrescriptionDetailService;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PrescriptionDetailMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PrescriptionDetailDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescription-details")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class PrescriptionDetailController {

    private final PrescriptionDetailService prescriptionDetailService;

    @PostMapping
    public ResponseEntity<PrescriptionDetailDTO> createDetail(@RequestBody @Valid PrescriptionDetailDTO detailDTO) {
        PrescriptionDetailDTO createdDetail = PrescriptionDetailMapper.toDTO(
                prescriptionDetailService.create(PrescriptionDetailMapper.toDomain(detailDTO))
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDetailDTO> getDetailById(@PathVariable String id) {
        return prescriptionDetailService.getById(id)
                .map(PrescriptionDetailMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionDetailDTO>> getAllDetails() {
        List<PrescriptionDetailDTO> details = prescriptionDetailService.getAll()
                .stream()
                .map(PrescriptionDetailMapper::toDTO)
                .toList();
        return ResponseEntity.ok(details);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionDetailDTO> updateDetail(
            @PathVariable String id,
            @RequestBody  @Valid  PrescriptionDetailDTO detailDTO) {
        detailDTO.setId(id);
        PrescriptionDetailDTO updatedDetail = PrescriptionDetailMapper.toDTO(
                prescriptionDetailService.update(PrescriptionDetailMapper.toDomain(detailDTO))
        );
        return ResponseEntity.ok(updatedDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetail(@PathVariable String id) {
        prescriptionDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-prescription/{prescriptionId}")
    public ResponseEntity<List<PrescriptionDetailDTO>> getDetailsByPrescription(
            @PathVariable String prescriptionId) {
        List<PrescriptionDetailDTO> details = prescriptionDetailService.getByPrescriptionId(prescriptionId)
                .stream()
                .map(PrescriptionDetailMapper::toDTO)
                .toList();
        return ResponseEntity.ok(details);
    }
}