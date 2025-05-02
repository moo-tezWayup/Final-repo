package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;

import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PrescriptionDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionDetailJpaRepository extends JpaRepository<PrescriptionDetailEntity,String> {
}
