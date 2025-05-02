package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;

import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PharmacyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyJpaRepository  extends JpaRepository<PharmacyEntity,String> {
}
