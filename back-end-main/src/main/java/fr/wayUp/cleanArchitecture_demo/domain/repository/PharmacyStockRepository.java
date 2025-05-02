package fr.wayUp.cleanArchitecture_demo.domain.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.PharmacyStock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PharmacyStockRepository {
    PharmacyStock save(PharmacyStock pharmacyStock);
    PharmacyStock update(PharmacyStock pharmacyStock);
    List<PharmacyStock> findAll();
    Optional<PharmacyStock> findById(String id);
    void delete(String id);


}