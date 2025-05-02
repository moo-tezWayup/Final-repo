package fr.wayUp.cleanArchitecture_demo.domain.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Prescription;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository {

    List<Prescription> findAllPrescriptions();
    Optional<Prescription> findPrescriptionById(String id);

    Prescription CreatePrescription(Prescription prescription);
    Prescription update(Prescription prescription);
    void deleteById(String id);
}
