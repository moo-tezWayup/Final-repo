package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;

import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ServiceJpaRepository extends JpaRepository<ServiceEntity, String> {

    List<ServiceEntity> findByClinicId(String clinicId);
}

