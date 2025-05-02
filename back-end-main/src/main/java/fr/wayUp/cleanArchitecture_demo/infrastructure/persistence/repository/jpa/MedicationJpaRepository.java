package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;


import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationJpaRepository  extends JpaRepository<MedicationEntity, String> {

}
