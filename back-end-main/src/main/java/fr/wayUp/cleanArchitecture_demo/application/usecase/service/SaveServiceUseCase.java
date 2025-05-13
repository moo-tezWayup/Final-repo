package fr.wayUp.cleanArchitecture_demo.application.usecase.service;

import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveServiceUseCase {
    private final ServiceRepository serviceRepository ;

    public Service create(Service service){
            return  this.serviceRepository.save(service);
    }
}
