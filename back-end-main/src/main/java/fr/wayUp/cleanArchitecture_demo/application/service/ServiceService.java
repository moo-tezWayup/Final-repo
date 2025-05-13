package fr.wayUp.cleanArchitecture_demo.application.service;
import  fr.wayUp.cleanArchitecture_demo.application.usecase.service.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {
    private final  GetServiceUseCase getServiceUseCase;
    private final  GetListServicesUseCase getListServicesUseCase ;
    private final DeleteServiceUseCase deleteServiceUseCase ;
    private final SaveServiceUseCase saveServiceUseCase;
    private final UpdateServiceUseCase updateServiceUseCase;
    private final  GetServicesByClinicIdUseCase getServicesByClinicIdUseCase;

    public List<Service> getAllService() {
        return this.getListServicesUseCase.execute();
    }
    public Optional<Service> getServiceById(String id) {
         return   this.getServiceUseCase.find(id);
    }
    public Service createService(Service service) {
        return this.saveServiceUseCase.create(service);
    }

    public void deleteService(String id) {
        this.deleteServiceUseCase.delete(id);
    }
    public Service updateService(ServiceDTO serviceDTO, Service existingService){
        return this.updateServiceUseCase.update(serviceDTO, existingService);
    }
    public List<Service> getByClinicId(String clinicId){
    return this.getServicesByClinicIdUseCase.find(clinicId);
    }
}
