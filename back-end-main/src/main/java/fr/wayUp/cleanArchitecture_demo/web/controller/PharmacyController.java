package fr.wayUp.cleanArchitecture_demo.web.controller;

import fr.wayUp.cleanArchitecture_demo.application.service.PharmacyService;
import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PharmacyMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PharmacyDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pharmacy")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class PharmacyController {

    private final PharmacyService pharmacyService;

    @GetMapping
    public ResponseEntity<List<PharmacyDTO>> getAllPharmacies() {
        List<PharmacyDTO> pharmacies = pharmacyService.findAllPharmacies()
                .stream()
                .map(PharmacyMapper::toDTO)
                .toList();

        return ResponseEntity.ok(pharmacies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PharmacyDTO> getPharmacyById(@PathVariable String id) {
        Optional<PharmacyDTO> pharmacy = pharmacyService.findPharmacyById(id)
                .map(PharmacyMapper::toDTO);

        return pharmacy.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addPharmacy")
    public ResponseEntity<PharmacyDTO> createPharmacy(@RequestBody @Valid PharmacyDTO pharmacyDTO) {
        PharmacyDTO savedPharmacy = PharmacyMapper.toDTO(pharmacyService.save( PharmacyMapper.toDomain(pharmacyDTO)));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPharmacy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePharmacy(@PathVariable String id) {
        pharmacyService.deletePharmacyById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PharmacyDTO> updatePharmacy(
            @PathVariable String id,
            @RequestBody Map<String, Object> updates) {

        Pharmacy updatedPharmacy = pharmacyService.updatePharmacy(id, updates);
        return ResponseEntity.ok(PharmacyMapper.toDTO(updatedPharmacy));
    }
}