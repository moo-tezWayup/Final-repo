package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ServiceEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public static Service toDomain(ServiceEntity entity) {
        if (entity == null) return null;

        return Service.builder()
                .id(entity.getId())
                .name(entity.getName())
                .role(entity.getRole())
                .description(entity.getDescription())
                .imageDir(entity.getImageDir())
                .clinicId(entity.getClinic() != null ? entity.getClinic().getId() : null)
                .build();
    }

    public static Service toDomain(ServiceDTO dto) {
        if (dto == null) return null;

        return Service.builder()
                .id(dto.getId())
                .name(dto.getName())
                .role(dto.getRole())
                .description(dto.getDescription())
                .imageDir(dto.getImageDir())
                .clinicId(dto.getClinicId())
                .build();
    }

    public static ServiceEntity toEntity(Service domain) {
        if (domain == null) return null;

        return ServiceEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .role(domain.getRole())
                .description(domain.getDescription())
                .imageDir(domain.getImageDir())
                // Note: Clinic doit être setté séparément
                .build();
    }

    public static ServiceEntity toEntity(ServiceDTO dto) {
        if (dto == null) return null;

        return ServiceEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .role(dto.getRole())
                .description(dto.getDescription())
                .imageDir(dto.getImageDir())
                // Note: Clinic doit être setté séparément
                .build();
    }

    public static ServiceDTO toDTO(Service domain) {
        if (domain == null) return null;

        return ServiceDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .role(domain.getRole())
                .description(domain.getDescription())
                .imageDir(domain.getImageDir())
                .clinicId(domain.getClinicId())
                .build();
    }

    public static ServiceDTO toDTO(ServiceEntity entity) {
        if (entity == null) return null;

        return ServiceDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .role(entity.getRole())
                .description(entity.getDescription())
                .imageDir(entity.getImageDir())
                .clinicId(entity.getClinic() != null ? entity.getClinic().getId() : null)
                .build();
    }
}