package fr.wayUp.cleanArchitecture_demo.application.usecase.staff;

import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class FindStaffBySpecialtyUseCase {
    private final StaffRepository staffRepository;

    public  List<Staff> find(String specialty){
        return  this.staffRepository.findBySpecialty(specialty);
    }
}
