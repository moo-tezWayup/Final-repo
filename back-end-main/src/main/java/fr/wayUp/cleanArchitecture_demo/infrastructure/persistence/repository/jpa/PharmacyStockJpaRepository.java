package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;

import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PharmacyEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PharmacyStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyStockJpaRepository extends JpaRepository<PharmacyStockEntity,String> {
}
