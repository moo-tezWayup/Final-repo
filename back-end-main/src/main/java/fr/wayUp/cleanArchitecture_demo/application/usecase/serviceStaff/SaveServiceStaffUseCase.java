package fr.wayUp.cleanArchitecture_demo.application.usecase.serviceStaff;

import fr.wayUp.cleanArchitecture_demo.domain.model.ServiceStaff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveServiceStaffUseCase {
    private final ServiceStaffRepository serviceStaffRepository;


    public ServiceStaff create(ServiceStaff serviceStaff){
        return  this.serviceStaffRepository.saveServiceStaff(serviceStaff);
    }
}
