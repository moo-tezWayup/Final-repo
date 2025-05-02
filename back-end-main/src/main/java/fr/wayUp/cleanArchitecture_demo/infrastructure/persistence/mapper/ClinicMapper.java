package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Clinic;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ClinicEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ClinicDTO;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Component
public class ClinicMapper {
    public static Clinic toDomain(ClinicEntity clinicEntity) {
        requireNonNull(clinicEntity, "clinic entity should not be null!");
        return Clinic.builder()
                .id(clinicEntity.getId())
                .name(clinicEntity.getName())
                .address(clinicEntity.getAddress())
                .phone(clinicEntity.getPhone())
                .email(clinicEntity.getEmail())
                .imageDir(clinicEntity.getImageDir())
                .build();
    }

    public static Clinic toDomain(ClinicDTO clinicDTO) {
        requireNonNull(clinicDTO, "clinic DTO should not be null!");
        return Clinic.builder()
                .id(clinicDTO.getId())
                .name(clinicDTO.getName())
                .address(clinicDTO.getAddress())
                .phone(clinicDTO.getPhone())
                .email(clinicDTO.getEmail())
                .imageDir(clinicDTO.getImageDir())
                .build();
    }

    public static ClinicEntity toEntity(Clinic clinic) {
        requireNonNull(clinic, "clinic should not be null!");
        return ClinicEntity.builder()
                .id(clinic.getId())
                .name(clinic.getName())
                .address(clinic.getAddress())
                .phone(clinic.getPhone())
                .email(clinic.getEmail())
                .imageDir(clinic.getImageDir())
                .build();
    }

    public static ClinicEntity toEntity(ClinicDTO clinicDTO) {
        requireNonNull(clinicDTO, "clinic DTO should not be null!");
        return ClinicEntity.builder()
                .id(clinicDTO.getId())
                .name(clinicDTO.getName())
                .address(clinicDTO.getAddress())
                .phone(clinicDTO.getPhone())
                .email(clinicDTO.getEmail())
                .imageDir(clinicDTO.getImageDir())
                .build();
    }

    public static ClinicDTO toDTO(Clinic clinic) {
        requireNonNull(clinic, "clinic should not be null!");
        return ClinicDTO.builder()
                .id(clinic.getId())
                .name(clinic.getName())
                .address(clinic.getAddress())
                .phone(clinic.getPhone())
                .email(clinic.getEmail())
                .imageDir(clinic.getImageDir())
                .build();
    }

    public static ClinicDTO toDTO(ClinicEntity clinicEntity) {
        requireNonNull(clinicEntity, "clinic entity should not be null!");
        return ClinicDTO.builder()
                .id(clinicEntity.getId())
                .name(clinicEntity.getName())
                .address(clinicEntity.getAddress())
                .phone(clinicEntity.getPhone())
                .email(clinicEntity.getEmail())
                .imageDir(clinicEntity.getImageDir())
                .build();
    }

    public static List<ClinicDTO> entityToDTO(List<ClinicEntity> clinics) {
        return clinics.stream()
                .map(ClinicMapper::toDTO)
                .toList();
    }

    public static List<ClinicDTO> clinicToDTO(List<Clinic> clinics) {
        return clinics.stream()
                .map(ClinicMapper::toDTO)
                .toList();
    }


}
