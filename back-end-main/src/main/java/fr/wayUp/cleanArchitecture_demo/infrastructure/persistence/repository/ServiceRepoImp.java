package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ServiceEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ServiceMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.ServiceJpaRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ServiceRepoImp   implements ServiceRepository {
    private final ServiceJpaRepository serviceJpaRepository ;

    public ServiceRepoImp(ServiceJpaRepository serviceJpaRepository) {
        this.serviceJpaRepository = serviceJpaRepository;
    }


    @Override
    public Service save(Service service) {
        ServiceEntity entity = ServiceMapper.toEntity(service);
        ServiceEntity savedEntity = serviceJpaRepository.save(entity);
        return ServiceMapper.toDomain(savedEntity);
    }

    @Override
    public List<Service> findAllServices() {
        return this.serviceJpaRepository.findAll()
                .stream()
                .map(ServiceMapper :: toDomain)
                .toList();
    }

    @Override
    public List<Service> findByClinicId(String clinicId) {
        return this.serviceJpaRepository.findByClinicId(clinicId)
                .stream()
                .map(ServiceMapper :: toDomain)
                .toList();

    }

    @Override
    public Optional<Service> findServiceById(String id) {
        return this.serviceJpaRepository.findById(id).map(ServiceMapper :: toDomain);
    }

    @Override
    public Service updateService(ServiceDTO serviceDTO, Service existingService) {
            if (serviceDTO.getName() != null) {
                existingService.setName(serviceDTO.getName());
            }
            if (serviceDTO.getRole() != null) {
                existingService.setRole(serviceDTO.getRole());
            }
            if (serviceDTO.getDescription() != null) {
                existingService.setDescription(serviceDTO.getDescription());
            }
            if (serviceDTO.getClinicId() != null) {
                existingService.setClinicId(serviceDTO.getClinicId());
            }

            return this.save(existingService);
        }


    @Override
    public void deleteServiceById(String id) {
        if (this.findServiceById(id).isEmpty())
            System.out.println("--------------------- ID does not exist ----------------");
        else
                this.serviceJpaRepository.deleteById(id);
    }
}

