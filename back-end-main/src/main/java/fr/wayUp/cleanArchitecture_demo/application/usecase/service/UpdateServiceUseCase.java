package fr.wayUp.cleanArchitecture_demo.application.usecase.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.staff.GetStaffUseCase;
import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
@RequiredArgsConstructor
@Component
public class UpdateServiceUseCase {

public final ServiceRepository serviceRepository;
public final GetServiceUseCase getServiceUseCase;
public final GetStaffUseCase getStaffUseCase ;



    public Service update(ServiceDTO serviceDTO, Service existingService){
        Service service = getServiceUseCase.find(serviceDTO.getId()).orElseThrow(() -> new RuntimeException("Service not found with ID: " + serviceDTO.getId()));
        return this.serviceRepository.updateService(serviceDTO, existingService);
}

}