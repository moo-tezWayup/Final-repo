package fr.wayUp.cleanArchitecture_demo.application.usecase.service;
import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetListServicesUseCase {
    private final ServiceRepository serviceRepository ;

    public List<Service>  execute(){
        return this.serviceRepository.findAllServices();
    }
}
