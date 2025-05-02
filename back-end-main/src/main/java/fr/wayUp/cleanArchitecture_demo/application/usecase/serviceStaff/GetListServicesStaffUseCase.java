package fr.wayUp.cleanArchitecture_demo.application.usecase.serviceStaff;

import fr.wayUp.cleanArchitecture_demo.domain.model.ServiceStaff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetListServicesStaffUseCase {
    private final ServiceStaffRepository serviceStaffRepository;



    public List<ServiceStaff> find(){
        return this.serviceStaffRepository.findAllServicesStaff();
    }
}
