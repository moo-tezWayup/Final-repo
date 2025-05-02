package fr.wayUp.cleanArchitecture_demo.web.controller;


import fr.wayUp.cleanArchitecture_demo.application.service.PharmacyStockService;
import fr.wayUp.cleanArchitecture_demo.domain.model.PharmacyStock;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PharmacyStockMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PharmacyStockDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pharmacy-stocks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class PharmacyStockController {

    private final PharmacyStockService pharmacyStockService;

    @GetMapping
    public ResponseEntity<List<PharmacyStockDTO>> getAllStocks() {
        List<PharmacyStockDTO> stocks = pharmacyStockService.getAll()
                .stream()
                .map(PharmacyStockMapper::toDTO)
                .toList();
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PharmacyStockDTO> getStockById(@PathVariable String id) {
        Optional<PharmacyStockDTO> stock = pharmacyStockService.getById(id)
                .map(PharmacyStockMapper::toDTO);
        return stock.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PharmacyStockDTO> createStock(@RequestBody @Valid PharmacyStockDTO stockDTO) {
        PharmacyStockDTO createdStock = PharmacyStockMapper.toDTO(
                pharmacyStockService.create(PharmacyStockMapper.toDomain(stockDTO))
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PharmacyStockDTO> updateStock(
            @PathVariable String id,
            @RequestBody @Valid PharmacyStockDTO stockDTO) {
        stockDTO.setId(id);
        PharmacyStockDTO updatedStock = PharmacyStockMapper.toDTO(
                pharmacyStockService.update(PharmacyStockMapper.toDomain(stockDTO))
        );
        return ResponseEntity.ok(updatedStock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable String id) {
        pharmacyStockService.delete(id);
        return ResponseEntity.noContent().build();
    }
/*
    @GetMapping("/by-pharmacy/{pharmacyId}")
    public ResponseEntity<List<PharmacyStockDTO>> getStocksByPharmacy(@PathVariable String pharmacyId) {
        List<PharmacyStockDTO> stocks = pharmacyStockService.getByPharmacyId(pharmacyId)
                .stream()
                .map(PharmacyStockMapper::toDTO)
                .toList();
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/by-medication/{medicationId}")
    public ResponseEntity<List<PharmacyStockDTO>> getStocksByMedication(@PathVariable String medicationId) {
        List<PharmacyStockDTO> stocks = pharmacyStockService.getByMedicationId(medicationId)
                .stream()
                .map(PharmacyStockMapper::toDTO)
                .toList();
        return ResponseEntity.ok(stocks);
    }

    @PatchMapping("/{id}/update-quantity")
    public ResponseEntity<PharmacyStockDTO> updateStockQuantity(
            @PathVariable String id,
            @RequestParam Integer quantityChange) {
        PharmacyStockDTO updatedStock = PharmacyStockMapper.toDTO(
                pharmacyStockService.updateStockQuantity(id, quantityChange)
        );
        return ResponseEntity.ok(updatedStock);
    }
    */
}