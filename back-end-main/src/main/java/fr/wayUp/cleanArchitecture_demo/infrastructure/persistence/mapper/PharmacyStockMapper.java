package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.PharmacyStock;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PharmacyStockEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PharmacyStockDTO;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

import java.util.List;

@Component
public class PharmacyStockMapper {

    public static PharmacyStock toDomain(PharmacyStockEntity entity) {
        requireNonNull(entity, "PharmacyStock entity should not be null!");
        return PharmacyStock.builder()
                .id(entity.getId())
                .pharmacyId(entity.getPharmacyId())
                .medicationId(entity.getMedicationId())
                .quantity(entity.getQuantity())
                .receivedDate(entity.getReceivedDate())
                .build();
    }

    public static PharmacyStock toDomain(PharmacyStockDTO dto) {
        requireNonNull(dto, "PharmacyStock DTO should not be null!");
        return PharmacyStock.builder()
                .id(dto.getId())
                .pharmacyId(dto.getPharmacyId())
                .medicationId(dto.getMedicationId())
                .quantity(dto.getQuantity())
                .receivedDate(dto.getReceivedDate())
                .build();
    }

    public static PharmacyStockEntity toEntity(PharmacyStock domain) {
        requireNonNull(domain, "PharmacyStock should not be null!");
        return PharmacyStockEntity.builder()
                .id(domain.getId())
                .pharmacyId(domain.getPharmacyId())
                .medicationId(domain.getMedicationId())
                .quantity(domain.getQuantity())
                .receivedDate(domain.getReceivedDate())
                .build();
    }

    public static PharmacyStockDTO toDTO(PharmacyStock domain) {
        requireNonNull(domain, "PharmacyStock should not be null!");
        return PharmacyStockDTO.builder()
                .id(domain.getId())
                .pharmacyId(domain.getPharmacyId())
                .medicationId(domain.getMedicationId())
                .quantity(domain.getQuantity())
                .receivedDate(domain.getReceivedDate())
                .build();
    }

    public static List<PharmacyStockDTO> toDTOList(List<PharmacyStock> stocks) {
        return stocks.stream()
                .map(PharmacyStockMapper::toDTO)
                .toList();
    }
}