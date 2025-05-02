package fr.wayUp.cleanArchitecture_demo.application.usecase.patient;

import fr.wayUp.cleanArchitecture_demo.domain.model.Patient;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class GetPatientUseCase {
    private final PatientRepository patientRepository;


    public Optional<Patient> execute(String id){
        return patientRepository.findPatientById(id);
    }
}