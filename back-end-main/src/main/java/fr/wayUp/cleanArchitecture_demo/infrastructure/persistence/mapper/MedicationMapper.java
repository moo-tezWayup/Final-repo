package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Medication;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.MedicationEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.MedicationDTO;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

import java.util.List;

@Component
public class MedicationMapper {

    public static Medication toDomain(MedicationEntity entity) {
        requireNonNull(entity, "Medication entity should not be null!");
        return Medication.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .prescriptionDetailId(entity.getPrescriptionDetailId())
                .build();
    }

    public static Medication toDomain(MedicationDTO dto) {
        requireNonNull(dto, "Medication DTO should not be null!");
        return Medication.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .prescriptionDetailId(dto.getPrescriptionDetailId())
                .build();
    }

    public static MedicationEntity toEntity(Medication domain) {
        requireNonNull(domain, "Medication should not be null!");
        return MedicationEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice())
                .stock(domain.getStock())
                .prescriptionDetailId(domain.getPrescriptionDetailId())
                .build();
    }

    public static MedicationDTO toDTO(Medication domain) {
        requireNonNull(domain, "Medication should not be null!");
        return MedicationDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice())
                .stock(domain.getStock())
                .prescriptionDetailId(domain.getPrescriptionDetailId())
                .build();
    }

    public static List<MedicationDTO> toDTOList(List<Medication> medications) {
        return medications.stream()
                .map(MedicationMapper::toDTO)
                .toList();
    }
}