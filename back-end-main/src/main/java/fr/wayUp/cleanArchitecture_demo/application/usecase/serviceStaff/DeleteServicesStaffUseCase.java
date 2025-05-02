package fr.wayUp.cleanArchitecture_demo.application.usecase.serviceStaff;

import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteServicesStaffUseCase {
    private final ServiceStaffRepository serviceStaffRepository;
    public void delete(String id) {
        serviceStaffRepository.delete(id);
    }
}
