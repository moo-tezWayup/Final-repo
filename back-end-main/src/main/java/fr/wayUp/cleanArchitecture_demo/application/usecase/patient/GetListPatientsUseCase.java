package fr.wayUp.cleanArchitecture_demo.application.usecase.patient;

import fr.wayUp.cleanArchitecture_demo.domain.model.Patient;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetListPatientsUseCase {
    private final PatientRepository patientRepository;



    public List<Patient> execute(){
        return patientRepository.findAllPatients();
    }
}