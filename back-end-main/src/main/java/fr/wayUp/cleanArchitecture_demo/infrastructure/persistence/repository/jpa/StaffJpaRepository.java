package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;
import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.StaffRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffJpaRepository extends JpaRepository<StaffEntity, String> {

    List<StaffEntity> findBySpecialtyAndGrade(String specialty, String grade);

}
