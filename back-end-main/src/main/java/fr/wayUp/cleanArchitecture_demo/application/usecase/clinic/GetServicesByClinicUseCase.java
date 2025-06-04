package fr.wayUp.cleanArchitecture_demo.application.usecase.clinic;

import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetServicesByClinicUseCase {
    @Autowired
    private final ServiceRepository serviceRepository;

    public List<Service> execute(String clinicId) {
        return this.serviceRepository.findByClinicId(clinicId);
    }
}