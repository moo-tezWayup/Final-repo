package fr.wayUp.cleanArchitecture_demo.application.usecase.staff;

import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.StaffRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.StaffDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UpdateStaffUseCase {
    private final GetStaffUseCase getStaffUseCase;
    private  final StaffRepository staffRepository;




    public Staff update(StaffDTO staffDTO, Staff existingStaff)  {

        return  staffRepository.updateStaff(staffDTO,existingStaff);
    }



}
