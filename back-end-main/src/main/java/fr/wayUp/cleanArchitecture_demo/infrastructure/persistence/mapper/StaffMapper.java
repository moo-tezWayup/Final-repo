package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.StaffEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.StaffDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Component
public class StaffMapper {

    public static Staff toDomain(StaffEntity staffEntity) {
        requireNonNull(staffEntity, "staff entity should not be null!");

        return Staff.builder()
                .id(staffEntity.getId())
                .firstName(staffEntity.getFirstName())
                .lastName(staffEntity.getLastName())
                .grade(staffEntity.getGrade())
                .hireDate(staffEntity.getHireDate())
                .address(staffEntity.getAddress())
                .phone(staffEntity.getPhone())
                .email(staffEntity.getEmail())
                .cin(staffEntity.getCin())
                .imageDir(staffEntity.getImageDir())
                //  Relations internes
                .secretaireId(
                        Optional.ofNullable(staffEntity.getSecretaire())
                                .map(StaffEntity::getId)
                                .orElse(null)
                )
                .medecinIds(
                        staffEntity.getMedecins() != null ?
                                staffEntity.getMedecins().stream()
                                        .map(StaffEntity::getId)
                                        .collect(Collectors.toList())
                                : null
                )
                .build();
    }

    public static Staff toDomain(StaffDTO staffDTO) {
        requireNonNull(staffDTO, "staff DTO should not be null!");

        return Staff.builder()
                .id(staffDTO.getId())
                .firstName(staffDTO.getFirstName())
                .lastName(staffDTO.getLastName())
                .grade(staffDTO.getGrade())
                .hireDate(staffDTO.getHireDate())
                .address(staffDTO.getAddress())
                .phone(staffDTO.getPhone())
                .email(staffDTO.getEmail())
                .cin(staffDTO.getCin())
                .imageDir(staffDTO.getImageDir())
                .secretaireId(staffDTO.getSecretaireId())
                .medecinIds(staffDTO.getMedecinIds())
                .build();
    }

    public static StaffEntity toEntity(Staff staff) {
        requireNonNull(staff, "staff should not be null!");

        // Ne pas setter `secretaire` ni `medecins` ici directement.
        // Cela doit être fait dans le service avec repository.findById().

        return StaffEntity.builder()
                .id(staff.getId())
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .grade(staff.getGrade())
                .hireDate(staff.getHireDate())
                .address(staff.getAddress())
                .phone(staff.getPhone())
                .email(staff.getEmail())
                .cin(staff.getCin())
                .imageDir(staff.getImageDir())
                .build();
    }

    public static StaffEntity toEntity(StaffDTO staffDTO) {
        requireNonNull(staffDTO, "staff DTO should not be null!");

        return StaffEntity.builder()
                .id(staffDTO.getId())
                .firstName(staffDTO.getFirstName())
                .lastName(staffDTO.getLastName())
                .grade(staffDTO.getGrade())
                .hireDate(staffDTO.getHireDate())
                .address(staffDTO.getAddress())
                .phone(staffDTO.getPhone())
                .email(staffDTO.getEmail())
                .cin(staffDTO.getCin())
                .imageDir(staffDTO.getImageDir())
                .build();
    }

    public static StaffDTO toDTO(Staff staff) {
        requireNonNull(staff, "staff should not be null!");

        return StaffDTO.builder()
                .id(staff.getId())
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .grade(staff.getGrade())
                .hireDate(staff.getHireDate())
                .address(staff.getAddress())
                .phone(staff.getPhone())
                .email(staff.getEmail())
                .cin(staff.getCin())
                .imageDir(staff.getImageDir())
                .secretaireId(staff.getSecretaireId())
                .medecinIds(staff.getMedecinIds())
                .build();
    }

    public static StaffDTO toDTO(StaffEntity staffEntity) {
        requireNonNull(staffEntity, "staff entity should not be null!");

        return StaffDTO.builder()
                .id(staffEntity.getId())
                .firstName(staffEntity.getFirstName())
                .lastName(staffEntity.getLastName())
                .grade(staffEntity.getGrade())
                .hireDate(staffEntity.getHireDate())
                .address(staffEntity.getAddress())
                .phone(staffEntity.getPhone())
                .email(staffEntity.getEmail())
                .cin(staffEntity.getCin())
                .imageDir(staffEntity.getImageDir())
                .secretaireId(
                        Optional.ofNullable(staffEntity.getSecretaire())
                                .map(StaffEntity::getId)
                                .orElse(null)
                )
                .medecinIds(
                        staffEntity.getMedecins() != null ?
                                staffEntity.getMedecins().stream()
                                        .map(StaffEntity::getId)
                                        .collect(Collectors.toList())
                                : null
                )
                .build();
    }

    public static List<StaffDTO> EntityToDTO(List<StaffEntity> staff) {
        return staff.stream().map(StaffMapper::toDTO).toList();
    }

    public static List<StaffDTO> staffToDTO(List<Staff> staff) {
        return staff.stream().map(StaffMapper::toDTO).toList();
    }
}
