package fr.wayUp.cleanArchitecture_demo.application.usecase.staff;

import fr.wayUp.cleanArchitecture_demo.domain.repository.StaffRepository;
import  fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetListStaffUseCase {
    private final StaffRepository staffRepository;

    public List<Staff> execute(){return staffRepository.findAllStaff();}

}
