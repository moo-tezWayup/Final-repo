package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Consultation;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ConsultationEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ConsultationDTO;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

import java.util.List;

@Component
public class ConsultationMapper {

    public static Consultation toDomain(ConsultationEntity consultationEntity) {
        requireNonNull(consultationEntity, "consultation entity should not be null!");
        return Consultation.builder()
                .id(consultationEntity.getId())
                .patientId(consultationEntity.getPatientId())
                .doctorId(consultationEntity.getDoctorId())
                .date(consultationEntity.getDate())
                .notes(consultationEntity.getNotes())
                .build();
    }

    public static Consultation toDomain(ConsultationDTO consultationDTO) {
        requireNonNull(consultationDTO, "consultation DTO should not be null!");
        return Consultation.builder()
                .id(consultationDTO.getId())
                .patientId(consultationDTO.getPatientId())
                .doctorId(consultationDTO.getDoctorId())
                .date(consultationDTO.getDate())
                .notes(consultationDTO.getNotes())
                .build();
    }

    public static ConsultationEntity toEntity(Consultation consultation) {
        requireNonNull(consultation, "consultation should not be null!");
        return ConsultationEntity.builder()
                .id(consultation.getId())
                .patientId(consultation.getPatientId())
                .doctorId(consultation.getDoctorId())
                .date(consultation.getDate())
                .notes(consultation.getNotes())
                .build();
    }

    public static ConsultationEntity toEntity(ConsultationDTO consultationDTO) {
        requireNonNull(consultationDTO, "consultation DTO should not be null!");
        return ConsultationEntity.builder()
                .id(consultationDTO.getId())
                .patientId(consultationDTO.getPatientId())
                .doctorId(consultationDTO.getDoctorId())
                .date(consultationDTO.getDate())
                .notes(consultationDTO.getNotes())
                .build();
    }

    public static ConsultationDTO toDTO(Consultation consultation) {
        requireNonNull(consultation, "consultation should not be null!");
        return ConsultationDTO.builder()
                .id(consultation.getId())
                .patientId(consultation.getPatientId())
                .doctorId(consultation.getDoctorId())
                .date(consultation.getDate())
                .notes(consultation.getNotes())
                .build();
    }

    public static ConsultationDTO toDTO(ConsultationEntity consultationEntity) {
        requireNonNull(consultationEntity, "consultation entity should not be null!");
        return ConsultationDTO.builder()
                .id(consultationEntity.getId())
                .patientId(consultationEntity.getPatientId())
                .doctorId(consultationEntity.getDoctorId())
                .date(consultationEntity.getDate())
                .notes(consultationEntity.getNotes())
                .build();
    }

    public static List<ConsultationDTO> entityToDTO(List<ConsultationEntity> consultations) {
        return consultations.stream()
                .map(ConsultationMapper::toDTO)
                .toList();
    }

    public static List<ConsultationDTO> consultationToDTO(List<Consultation> consultations) {
        return consultations.stream()
                .map(ConsultationMapper::toDTO)
                .toList();
    }
}