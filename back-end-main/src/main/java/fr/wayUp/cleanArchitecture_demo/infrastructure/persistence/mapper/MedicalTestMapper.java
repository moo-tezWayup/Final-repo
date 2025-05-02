package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.MedicalTest;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.MedicalTestEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.MedicalTestDTO;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

import java.util.List;

@Component
public class MedicalTestMapper {

    public static MedicalTest toDomain(MedicalTestEntity entity) {
        requireNonNull(entity, "MedicalTest entity should not be null!");
        return MedicalTest.builder()
                .id(entity.getId())
                .prescriptionId(entity.getPrescriptionId())
                .type(entity.getType())
                .result(entity.getResult())
                .build();
    }

    public static MedicalTest toDomain(MedicalTestDTO dto) {
        requireNonNull(dto, "MedicalTest DTO should not be null!");
        return MedicalTest.builder()
                .id(dto.getId())
                .prescriptionId(dto.getPrescriptionId())
                .type(dto.getType())
                .result(dto.getResult())
                .build();
    }

    public static MedicalTestEntity toEntity(MedicalTest domain) {
        requireNonNull(domain, "MedicalTest should not be null!");
        return MedicalTestEntity.builder()
                .id(domain.getId())
                .prescriptionId(domain.getPrescriptionId())
                .type(domain.getType())
                .result(domain.getResult())
                .build();
    }

    public static MedicalTestEntity toEntity(MedicalTestDTO dto) {
        requireNonNull(dto, "MedicalTest DTO should not be null!");
        return MedicalTestEntity.builder()
                .id(dto.getId())
                .prescriptionId(dto.getPrescriptionId())
                .type(dto.getType())
                .result(dto.getResult())
                .build();
    }

    public static MedicalTestDTO toDTO(MedicalTest domain) {
        requireNonNull(domain, "MedicalTest should not be null!");
        return MedicalTestDTO.builder()
                .id(domain.getId())
                .prescriptionId(domain.getPrescriptionId())
                .type(domain.getType())
                .result(domain.getResult())
                .build();
    }

    public static MedicalTestDTO toDTO(MedicalTestEntity entity) {
        requireNonNull(entity, "MedicalTest entity should not be null!");
        return MedicalTestDTO.builder()
                .id(entity.getId())
                .prescriptionId(entity.getPrescriptionId())
                .type(entity.getType())
                .result(entity.getResult())
                .build();
    }

    public static List<MedicalTestDTO> entityToDTO(List<MedicalTestEntity> tests) {
        return tests.stream()
                .map(MedicalTestMapper::toDTO)
                .toList();
    }

    public static List<MedicalTestDTO> medicalTestToDTO(List<MedicalTest> tests) {
        return tests.stream()
                .map(MedicalTestMapper::toDTO)
                .toList();
    }
}