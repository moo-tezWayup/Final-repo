package fr.wayUp.cleanArchitecture_demo.domain.repository;
import fr.wayUp.cleanArchitecture_demo.domain.model.MedicalTest;


import java.util.List;
import java.util.Optional;


public interface MedicalTestRepository {
    MedicalTest save(MedicalTest medicalTest);
    MedicalTest update(MedicalTest medicalTest);
    List<MedicalTest> findAll();
    Optional<MedicalTest> findById(String id);

    void delete(String id);

}