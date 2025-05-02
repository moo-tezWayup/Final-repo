package fr.wayUp.cleanArchitecture_demo.application.usecase.patient;

import fr.wayUp.cleanArchitecture_demo.domain.model.Patient;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PatientRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdatePatientUseCase {
    private final PatientRepository patientRepository;


    public Patient update(PatientDTO patientDTO, Patient existingPatient){
        return this.patientRepository.update(patientDTO,existingPatient);
    }
}
