package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.patient.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.Patient;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PatientService {
    private final SavePatientUseCase savePatientUseCase;
    private final GetListPatientsUseCase getListPatientsUseCase;
    private final GetPatientUseCase getPatientUseCase;
    private final DeletePatientUseCase deletePatientUseCase;
    private  final UpdatePatientUseCase updatePatientUseCase;


    public Patient savePatient(Patient patient){
        return savePatientUseCase.execute(patient);
    }

    public List<Patient> getListPatients(){
        return getListPatientsUseCase.execute();
    }

    public Optional<Patient> getPatientById(String id){
        return getPatientUseCase.execute(id);
    }
    public void deletePatientById(String id){
        deletePatientUseCase.delete(id);
    }
    public Patient update(PatientDTO patientDTO, Patient existingPatient) {
        return this.updatePatientUseCase.update(patientDTO,existingPatient);
    }
}