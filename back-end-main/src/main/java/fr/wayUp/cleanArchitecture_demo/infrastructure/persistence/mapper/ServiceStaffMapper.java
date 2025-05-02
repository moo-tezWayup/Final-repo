package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;


import fr.wayUp.cleanArchitecture_demo.domain.model.ServiceStaff;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ServiceStaffEntity;

import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceStaffDTO;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Component
public class ServiceStaffMapper {
    public static ServiceStaff toDomain(ServiceStaffEntity entity) {
        requireNonNull(entity, "ServiceStaff entity should not be null!");
        return ServiceStaff.builder()
                .id(entity.getId())
                .serviceId(entity.getServiceId())
                .staffId(entity.getStaffId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .status(entity.getStatus())
                .build();
    }

    public static ServiceStaff toDomain(ServiceStaffDTO dto) {
        requireNonNull(dto, "ServiceStaff DTO should not be null!");
        return ServiceStaff.builder()
                .id(dto.getId())
                .serviceId(dto.getServiceId())
                .staffId(dto.getStaffId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .status(dto.getStatus())
                .build();
    }

    public static ServiceStaffEntity toEntity(ServiceStaff domain) {
        requireNonNull(domain, "ServiceStaff should not be null!");
        return ServiceStaffEntity.builder()
                .id(domain.getId())
                .serviceId(domain.getServiceId())
                .staffId(domain.getStaffId())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .status(domain.getStatus())
                .build();
    }

    public static ServiceStaffEntity toEntity(ServiceStaffDTO dto) {
        requireNonNull(dto, "ServiceStaff DTO should not be null!");
        return ServiceStaffEntity.builder()
                .id(dto.getId())
                .serviceId(dto.getServiceId())
                .staffId(dto.getStaffId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .status(dto.getStatus())
                .build();
    }

    public static ServiceStaffDTO toDTO(ServiceStaff domain) {
        requireNonNull(domain, "ServiceStaff should not be null!");
        return ServiceStaffDTO.builder()
                .id(domain.getId())
                .serviceId(domain.getServiceId())
                .staffId(domain.getStaffId())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .status(domain.getStatus())
                .build();
    }

    public static ServiceStaffDTO toDTO(ServiceStaffEntity entity) {
        requireNonNull(entity, "ServiceStaff entity should not be null!");
        return ServiceStaffDTO.builder()
                .id(entity.getId())
                .serviceId(entity.getServiceId())
                .staffId(entity.getStaffId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .status(entity.getStatus())
                .build();
    }

    public static List<ServiceStaffDTO> entityToDTO(List<ServiceStaffEntity> entities) {
        return entities.stream()
                .map(ServiceStaffMapper::toDTO)
                .toList();
    }

    public static List<ServiceStaffDTO> domainToDTO(List<ServiceStaff> domains) {
        return domains.stream()
                .map(ServiceStaffMapper::toDTO)
                .toList();
    }
}