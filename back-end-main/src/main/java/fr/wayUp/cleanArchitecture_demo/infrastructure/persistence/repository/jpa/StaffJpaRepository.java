package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffJpaRepository extends JpaRepository<StaffEntity, String> {

    List<StaffEntity> findBySpecialtyAndGrade(String grade, String doctor);

}
