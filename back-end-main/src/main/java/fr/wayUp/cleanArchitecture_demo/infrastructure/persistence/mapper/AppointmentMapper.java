package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Appointment;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.AppointmentEntity;
import org.springframework.stereotype.Component;
import fr.wayUp.cleanArchitecture_demo.web.DTO.AppointmentDTO;
import java.util.List;
import static java.util.Objects.requireNonNull;

@Component
public class AppointmentMapper {

    public static Appointment toDomain(AppointmentEntity entity) {
        requireNonNull(entity, "Appointment entity should not be null!");
        return Appointment.builder()
                .id(entity.getId())
                .serviceStaffId(entity.getServiceStaffId())
                .patientId(entity.getPatientId())
                .description(entity.getDescription())
                .type(entity.getType())
                .status(entity.getStatus())
                .date(entity.getDate())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }

    public static Appointment toDomain(AppointmentDTO dto) {
        requireNonNull(dto, "Appointment DTO should not be null!");
        return Appointment.builder()
                .id(dto.getId())
                .serviceStaffId(dto.getServiceStaffId())
                .patientId(dto.getPatientId())
                .description(dto.getDescription())
                .type(dto.getType())
                .status(dto.getStatus())
                .date(dto.getDate())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }

    public static AppointmentEntity toEntity(Appointment domain) {
        requireNonNull(domain, "Appointment should not be null!");
        return AppointmentEntity.builder()
                .id(domain.getId())
                .serviceStaffId(domain.getServiceStaffId())
                .patientId(domain.getPatientId())
                .description(domain.getDescription())
                .type(domain.getType())
                .status(domain.getStatus())
                .date(domain.getDate())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .build();
    }

    public static AppointmentEntity toEntity(AppointmentDTO dto) {
        requireNonNull(dto, "Appointment DTO should not be null!");
        return AppointmentEntity.builder()
                .id(dto.getId())
                .serviceStaffId(dto.getServiceStaffId())
                .patientId(dto.getPatientId())
                .description(dto.getDescription())
                .type(dto.getType())
                .status(dto.getStatus())
                .date(dto.getDate())
                .build();
    }

    public static AppointmentDTO toDTO(Appointment domain) {
        requireNonNull(domain, "Appointment should not be null!");
        return AppointmentDTO.builder()
                .id(domain.getId())
                .serviceStaffId(domain.getServiceStaffId())
                .patientId(domain.getPatientId())
                .description(domain.getDescription())
                .type(domain.getType())
                .status(domain.getStatus())
                .date(domain.getDate())
                .build();
    }

    public static AppointmentDTO toDTO(AppointmentEntity entity) {
        requireNonNull(entity, "Appointment entity should not be null!");
        return AppointmentDTO.builder()
                .id(entity.getId())
                .serviceStaffId(entity.getServiceStaffId())
                .patientId(entity.getPatientId())
                .description(entity.getDescription())
                .type(entity.getType())
                .status(entity.getStatus())
                .date(entity.getDate())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }

    public static List<AppointmentDTO> entityToDTO(List<AppointmentEntity> entities) {
        return entities.stream()
                .map(AppointmentMapper::toDTO)
                .toList();
    }

    public static List<AppointmentDTO> domainToDTO(List<Appointment> domains) {
        return domains.stream()
                .map(AppointmentMapper::toDTO)
                .toList();
    }

    public static List<Appointment> entityToDomain(List<AppointmentEntity> entities) {
        return entities.stream()
                .map(AppointmentMapper::toDomain)
                .toList();
    }

    public static List<AppointmentEntity> domainToEntity(List<Appointment> domains) {
        return domains.stream()
                .map(AppointmentMapper::toEntity)
                .toList();
    }
}