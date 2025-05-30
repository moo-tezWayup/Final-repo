package fr.wayUp.cleanArchitecture_demo.application.usecase.staff;

import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.StaffRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.StaffJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class GetStaffUseCase {
    private final StaffRepository staffRepository;



    public Optional<Staff> execute(String id){return this.staffRepository.findStaffById(id);}



}
