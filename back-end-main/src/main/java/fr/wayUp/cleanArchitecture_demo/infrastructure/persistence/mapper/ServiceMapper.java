package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ServiceEntity;

import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public static Service toDomain(ServiceEntity serviceEntity) {
        if (serviceEntity == null) {
            return null;
        }
        return Service.builder()
                .id(serviceEntity.getId())
                .role(serviceEntity.getRole())
                .clinicId(serviceEntity.getClinicId())
                .description(serviceEntity.getDescription())
                .name(serviceEntity.getName())
                //.responsible(StaffMapper.toDomain(serviceEntity.getResponsible()))
                .imageDir(serviceEntity.getImageDir())
                .build();
    }

    public static Service toDomain(ServiceDTO serviceDTO) {
        if (serviceDTO == null) {
            return null;
        }
        return Service.builder()
                .id(serviceDTO.getId())
                .role(serviceDTO.getRole())
                .clinicId(serviceDTO.getClinicId())
                .description(serviceDTO.getDescription())
                .name(serviceDTO.getName())
                .imageDir(serviceDTO.getImageDir())
                .build();
    }

    public static ServiceEntity toEntity(Service service) {
        if (service == null) {
            return null;
        }
        return ServiceEntity.builder()
                .id(service.getId())
                .role(service.getRole())
                .clinicId(service.getClinicId())
                .description(service.getDescription())
                .name(service.getName())
                .imageDir(service.getImageDir())
                .build();
    }

    public static ServiceEntity toEntity(ServiceDTO serviceDTO) {
        if (serviceDTO == null) {
            return null;
        }
        return ServiceEntity.builder()
                .id(serviceDTO.getId())
                .role(serviceDTO.getRole())
                .clinicId(serviceDTO.getClinicId())
                .description(serviceDTO.getDescription())
                .name(serviceDTO.getName())
                .imageDir(serviceDTO.getImageDir())
                .build();
    }

    public static ServiceDTO toDTO(Service service) {
        if (service == null) {
            return null;
        }
        return ServiceDTO.builder()
                .id(service.getId())
                .role(service.getRole())
                .clinicId(service.getClinicId())
                .description(service.getDescription())
                .name(service.getName())
                .imageDir(service.getImageDir())
                .build();
    }

    public static ServiceDTO toDTO(ServiceEntity serviceEntity) {
        if (serviceEntity == null) {
            return null;
        }
        return ServiceDTO.builder()
                .id(serviceEntity.getId())
                .role(serviceEntity.getRole())
                .clinicId(serviceEntity.getClinicId())
                .description(serviceEntity.getDescription())
                .name(serviceEntity.getName())
                .imageDir(serviceEntity.getImageDir())
                .build();
    }
}
