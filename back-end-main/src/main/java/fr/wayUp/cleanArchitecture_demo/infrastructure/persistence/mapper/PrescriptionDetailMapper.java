package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.PrescriptionDetail;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PrescriptionDetailEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PrescriptionDetailDTO;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

import java.util.List;

@Component
public class PrescriptionDetailMapper {

    public static PrescriptionDetail toDomain(PrescriptionDetailEntity entity) {
        requireNonNull(entity, "PrescriptionDetail entity should not be null!");
        return PrescriptionDetail.builder()
                .id(entity.getId())
                .prescriptionId(entity.getPrescriptionId())
                .dosage(entity.getDosage())
                .frequency(entity.getFrequency())
                .duration(entity.getDuration())
                .build();
    }

    public static PrescriptionDetail toDomain(PrescriptionDetailDTO dto) {
        requireNonNull(dto, "PrescriptionDetail DTO should not be null!");
        return PrescriptionDetail.builder()
                .id(dto.getId())
                .prescriptionId(dto.getPrescriptionId())
                .dosage(dto.getDosage())
                .frequency(dto.getFrequency())
                .duration(dto.getDuration())
                .build();
    }

    public static PrescriptionDetailEntity toEntity(PrescriptionDetail domain) {
        requireNonNull(domain, "PrescriptionDetail should not be null!");
        return PrescriptionDetailEntity.builder()
                .id(domain.getId())
                .prescriptionId(domain.getPrescriptionId())
                .dosage(domain.getDosage())
                .frequency(domain.getFrequency())
                .duration(domain.getDuration())
                .build();
    }

    public static PrescriptionDetailDTO toDTO(PrescriptionDetail domain) {
        requireNonNull(domain, "PrescriptionDetail should not be null!");
        return PrescriptionDetailDTO.builder()
                .id(domain.getId())
                .prescriptionId(domain.getPrescriptionId())
                .dosage(domain.getDosage())
                .frequency(domain.getFrequency())
                .duration(domain.getDuration())
                .build();
    }

    public static List<PrescriptionDetailDTO> toDTOList(List<PrescriptionDetail> details) {
        return details.stream()
                .map(PrescriptionDetailMapper::toDTO)
                .toList();
    }
}