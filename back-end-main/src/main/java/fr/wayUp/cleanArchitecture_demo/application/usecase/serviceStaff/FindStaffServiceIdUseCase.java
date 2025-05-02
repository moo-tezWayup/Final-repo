package fr.wayUp.cleanArchitecture_demo.application.usecase.serviceStaff;

import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class FindStaffServiceIdUseCase {
    private final ServiceStaffRepository serviceStaffRepository;

    public Optional<String> execute(String staffId, String serviceId){
        return this.serviceStaffRepository.findStaffServiceId(staffId,serviceId);
    }
}
