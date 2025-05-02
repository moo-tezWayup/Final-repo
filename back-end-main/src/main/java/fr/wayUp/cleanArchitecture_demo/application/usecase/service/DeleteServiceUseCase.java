package fr.wayUp.cleanArchitecture_demo.application.usecase.service;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteServiceUseCase {
    private final ServiceRepository serviceRepository ;


    public void delete(String id){
        this.serviceRepository.deleteServiceById(id);
    }
}
