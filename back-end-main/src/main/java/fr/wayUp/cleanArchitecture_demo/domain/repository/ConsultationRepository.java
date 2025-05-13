package fr.wayUp.cleanArchitecture_demo.domain.repository;
import fr.wayUp.cleanArchitecture_demo.domain.model.Consultation;


import java.util.List;
import java.util.Optional;

public interface ConsultationRepository {
    Consultation save(Consultation consultation);
    List<Consultation> findAll();
    Optional<Consultation> findById(String id);
    Consultation update(Consultation consultation);
    void deleteById(String id);
}
