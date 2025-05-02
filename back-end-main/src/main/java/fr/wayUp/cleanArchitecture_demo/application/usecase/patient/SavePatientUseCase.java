package fr.wayUp.cleanArchitecture_demo.application.usecase.patient;

import fr.wayUp.cleanArchitecture_demo.domain.model.Patient;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SavePatientUseCase {
    private final PatientRepository patientRepository;


    public Patient execute(Patient patient){
        return patientRepository.save(patient);
    }
}