package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Prescription;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PrescriptionEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PrescriptionDTO;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

import java.util.List;

@Component
public class PrescriptionMapper {

    public static Prescription toDomain(PrescriptionEntity entity) {
        requireNonNull(entity, "Prescription entity should not be null!");
        return Prescription.builder()
                .id(entity.getId())
                .consultationId(entity.getConsultationId())
                .prescriptionDate(entity.getPrescriptionDate())

                .build();
    }

    public static Prescription toDomain(PrescriptionDTO dto) {
        requireNonNull(dto, "Prescription DTO should not be null!");
        return Prescription.builder()
                .id(dto.getId())
                .consultationId(dto.getConsultationId())
                .prescriptionDate(dto.getPrescriptionDate())
                .build();
    }

    public static PrescriptionEntity toEntity(Prescription domain) {
        requireNonNull(domain, "Prescription should not be null!");
        return PrescriptionEntity.builder()
                .id(domain.getId())
                .consultationId(domain.getConsultationId())
                .prescriptionDate(domain.getPrescriptionDate())
                .build();
    }

    public static PrescriptionEntity toEntity(PrescriptionDTO dto) {
        requireNonNull(dto, "Prescription DTO should not be null!");
        return PrescriptionEntity.builder()
                .id(dto.getId())
                .consultationId(dto.getConsultationId())
                .prescriptionDate(dto.getPrescriptionDate())

                .build();
    }

    public static PrescriptionDTO toDTO(Prescription domain) {
        requireNonNull(domain, "Prescription should not be null!");
        return PrescriptionDTO.builder()
                .id(domain.getId())
                .consultationId(domain.getConsultationId())
                .prescriptionDate(domain.getPrescriptionDate())

                .build();
    }

    public static PrescriptionDTO toDTO(PrescriptionEntity entity) {
        requireNonNull(entity, "Prescription entity should not be null!");
        return PrescriptionDTO.builder()
                .id(entity.getId())
                .consultationId(entity.getConsultationId())
                .prescriptionDate(entity.getPrescriptionDate())

                .build();
    }

    public static List<PrescriptionDTO> entityToDTO(List<PrescriptionEntity> prescriptions) {
        return prescriptions.stream()
                .map(PrescriptionMapper::toDTO)
                .toList();
    }

    public static List<PrescriptionDTO> prescriptionToDTO(List<Prescription> prescriptions) {
        return prescriptions.stream()
                .map(PrescriptionMapper::toDTO)
                .toList();
    }
}