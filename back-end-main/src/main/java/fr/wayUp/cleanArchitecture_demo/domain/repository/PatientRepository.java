package fr.wayUp.cleanArchitecture_demo.domain.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Patient;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PatientDTO;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    Patient save(Patient patient);
    List<Patient> findAllPatients();
    Optional<Patient> findPatientById(String  id);
    Patient update(PatientDTO patientDTO, Patient existingPatient);
    void delete(String id);


}