package fr.wayUp.cleanArchitecture_demo.application.usecase.clinic;

import fr.wayUp.cleanArchitecture_demo.domain.model.Clinic;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class GetByIdClinicsUseCase {

    private  final ClinicRepository clinicRepository;
    public Optional<Clinic> execute(String id){
        return this.clinicRepository.findById(id);
    }
}
