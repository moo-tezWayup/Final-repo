package fr.wayUp.cleanArchitecture_demo.application.usecase.service;

import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ServiceMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class GetServiceUseCase {
    private final ServiceRepository serviceRepository ;

    public Optional<Service> find(String id){

        Optional<Service>  service  = this.serviceRepository.findServiceById(id);
        if (service.isEmpty())
            return null;
        else
            // return  service.map(ServiceMapper :: toDTO);
            return  service;
    }
}
