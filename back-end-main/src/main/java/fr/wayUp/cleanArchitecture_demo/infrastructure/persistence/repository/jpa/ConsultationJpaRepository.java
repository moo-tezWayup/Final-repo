package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;

import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ConsultationJpaRepository extends JpaRepository<ConsultationEntity, String> {

}