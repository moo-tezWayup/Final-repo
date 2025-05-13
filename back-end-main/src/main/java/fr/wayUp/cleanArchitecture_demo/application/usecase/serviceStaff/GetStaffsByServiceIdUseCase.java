package fr.wayUp.cleanArchitecture_demo.application.usecase.serviceStaff;

import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetStaffsByServiceIdUseCase {
    private final ServiceStaffRepository serviceStaffRepository;
    public List<String> execute(String service_Id){
        return  this.serviceStaffRepository.findDistinctStaffIdByServiceId(service_Id);

    }

}
