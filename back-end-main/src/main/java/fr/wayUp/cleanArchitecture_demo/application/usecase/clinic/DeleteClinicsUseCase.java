package fr.wayUp.cleanArchitecture_demo.application.usecase.clinic;

import fr.wayUp.cleanArchitecture_demo.domain.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteClinicsUseCase {
    private  final ClinicRepository clinicRepository;
    public void delete(String id){
        this.clinicRepository.deleteById(id);
    }
}
