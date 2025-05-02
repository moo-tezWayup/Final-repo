package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;


import fr.wayUp.cleanArchitecture_demo.domain.model.Patient;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PatientRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PatientMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.PatientJpaRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PatientDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepoImpl implements PatientRepository {
    private final PatientJpaRepository patientJpaRepository;

    public PatientRepoImpl(@Lazy PatientJpaRepository patientJpaRepository) {
        this.patientJpaRepository = patientJpaRepository;
    }

    @Override
    public Patient save(Patient patient) {
        return PatientMapper.toDomain( patientJpaRepository.save(PatientMapper.toEntity(patient)));
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientJpaRepository.findAll()
                .stream()
                .map(PatientMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Patient> findPatientById(String id) {
        return patientJpaRepository.findById(id)
                .map(PatientMapper::toDomain);
    }

    @Override
    public Patient update(PatientDTO patientDTO, Patient existingPatient) {
        if (patientDTO.getFirstName() != null) {
            existingPatient.setFirstName(patientDTO.getFirstName());
        }
        if (patientDTO.getLastName() != null) {
            existingPatient.setLastName(patientDTO.getLastName());
        }
        if (patientDTO.getBirthdate() != null) {
            existingPatient.setBirthdate(patientDTO.getBirthdate());
        }
        if (patientDTO.getGender() != null) {
            existingPatient.setGender(patientDTO.getGender());
        }
        if (patientDTO.getMobile() != null) {
            existingPatient.setMobile(patientDTO.getMobile());
        }
        if (patientDTO.getEmail() != null) {
            existingPatient.setEmail(patientDTO.getEmail());
        }

        return this.save(existingPatient);
    }

    @Override
    public void delete(String id) {
        this.patientJpaRepository.deleteById(id);

    }
}