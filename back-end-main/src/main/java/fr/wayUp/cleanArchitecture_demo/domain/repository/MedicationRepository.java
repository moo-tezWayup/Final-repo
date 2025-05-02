package fr.wayUp.cleanArchitecture_demo.domain.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Medication;
import java.util.List;
import java.util.Optional;


public interface MedicationRepository {
    Medication save( Medication medication);
    Medication update( Medication medication);
    List< Medication> findAll();
    Optional< Medication> findById(String id);

    void delete(String id);
}