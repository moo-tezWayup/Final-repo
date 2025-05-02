package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Patient;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PatientEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PatientDTO;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Component
public class PatientMapper {
    public static Patient toDomain(PatientEntity patientEntity) {
        requireNonNull(patientEntity, "patient entity should not be null!");
        return Patient.builder()
                .id(patientEntity.getId())
                .firstName(patientEntity.getFirstName())
                .lastName(patientEntity.getLastName())
                .birthdate(patientEntity.getBirthdate())
                .gender(patientEntity.getGender())
                .mobile(patientEntity.getMobile())
                .email(patientEntity.getEmail())
                .imageDir(patientEntity.getImageDir())
                .build();
    }

    public static Patient toDomain(PatientDTO patientDTO) {
        requireNonNull(patientDTO, "patient DTO should not be null!");
        return Patient.builder()
                .id(patientDTO.getId())
                .firstName(patientDTO.getFirstName())
                .lastName(patientDTO.getLastName())
                .birthdate(patientDTO.getBirthdate())
                .gender(patientDTO.getGender())
                .mobile(patientDTO.getMobile())
                .email(patientDTO.getEmail())
                .imageDir(patientDTO.getImageDir())
                .build();
    }

    public static PatientEntity toEntity(Patient patient) {
        requireNonNull(patient, "patient should not be null!");
        return PatientEntity.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .birthdate(patient.getBirthdate())
                .gender(patient.getGender())
                .mobile(patient.getMobile())
                .email(patient.getEmail())
                .imageDir(patient.getImageDir())
                .build();
    }

    public static PatientEntity toEntity(PatientDTO patientDTO) {
        requireNonNull(patientDTO, "patient DTO should not be null!");
        return PatientEntity.builder()
                .id(patientDTO.getId())
                .firstName(patientDTO.getFirstName())
                .lastName(patientDTO.getLastName())
                .birthdate(patientDTO.getBirthdate())
                .gender(patientDTO.getGender())
                .mobile(patientDTO.getMobile())
                .email(patientDTO.getEmail())
                .imageDir(patientDTO.getImageDir())
                .build();
    }

    public static PatientDTO toDTO(Patient patient) {
        requireNonNull(patient, "patient should not be null!");
        return PatientDTO.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .birthdate(patient.getBirthdate())
                .gender(patient.getGender())
                .mobile(patient.getMobile())
                .email(patient.getEmail())
                .imageDir(patient.getImageDir())
                .build();
    }

    public static PatientDTO toDTO(PatientEntity patientEntity) {
        requireNonNull(patientEntity, "patient entity should not be null!");
        return PatientDTO.builder()
                .id(patientEntity.getId())
                .firstName(patientEntity.getFirstName())
                .lastName(patientEntity.getLastName())
                .birthdate(patientEntity.getBirthdate())
                .gender(patientEntity.getGender())
                .mobile(patientEntity.getMobile())
                .email(patientEntity.getEmail())
                .imageDir(patientEntity.getImageDir())
                .build();
    }

    public static List<PatientDTO> entityToDTO(List<PatientEntity> patients) {
        return patients.stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    public static List<PatientDTO> patientToDTO(List<Patient> patients) {
        return patients.stream()
                .map(PatientMapper::toDTO)
                .toList();
    }
}