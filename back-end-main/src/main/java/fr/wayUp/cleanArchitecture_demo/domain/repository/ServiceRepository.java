package fr.wayUp.cleanArchitecture_demo.domain.repository;
import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;


import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    Service save(Service service);
    List<Service> findAllServices();
    List<Service> findByClinicId(String clinicId);
    Optional<Service> findServiceById(String id);
    Service updateService(ServiceDTO serviceDTO, Service existingService);
    void  deleteServiceById(String id);

}
