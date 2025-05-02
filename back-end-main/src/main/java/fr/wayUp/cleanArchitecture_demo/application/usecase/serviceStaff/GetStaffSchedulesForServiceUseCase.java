package fr.wayUp.cleanArchitecture_demo.application.usecase.serviceStaff;

import fr.wayUp.cleanArchitecture_demo.domain.model.ServiceStaff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Component
@RequiredArgsConstructor
public class GetStaffSchedulesForServiceUseCase {
    private final ServiceStaffRepository serviceStaffRepository;



    public List<Object> find(
            LocalDate date,
            LocalDateTime currentDateTime,
            String staffId,
            String serviceId){
       return  this.serviceStaffRepository.findStaffSchedulesForService(date,currentDateTime,staffId,serviceId);
    }
}
