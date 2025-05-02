package fr.wayUp.cleanArchitecture_demo.application.usecase.staff;

import fr.wayUp.cleanArchitecture_demo.domain.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteStaffUseCase {
    private final StaffRepository staffRepository;


    public void delete(String id){

        this.staffRepository.deleteStaffById(id);
    }
}
