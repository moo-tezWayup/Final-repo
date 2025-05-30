package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;

import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.MedicalTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MedicalTestJpaRepository  extends JpaRepository<MedicalTestEntity, String> {
}
