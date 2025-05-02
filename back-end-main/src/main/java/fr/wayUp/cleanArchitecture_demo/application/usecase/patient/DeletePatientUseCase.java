package fr.wayUp.cleanArchitecture_demo.application.usecase.patient;

import fr.wayUp.cleanArchitecture_demo.domain.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePatientUseCase {
    private final PatientRepository patientRepository;


    public void delete(String id){
        this.patientRepository.delete(id);
    }
}
