package fr.wayUp.cleanArchitecture_demo.application.service;
import fr.wayUp.cleanArchitecture_demo.application.usecase.staff.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.web.DTO.StaffDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffService {



    private final    GetListStaffUseCase getListStaffUseCase ;
    private final       GetStaffUseCase getStaffUseCase;
    private final SaveStaffUseCase saveStaffUseCase;
    private  final DeleteStaffUseCase deleteStaffUseCase;
    private final UpdateStaffUseCase updateStaffUseCase;
    public final FindStaffBySpecialtyUseCase findStaffBySpecialtyUseCase;





    public List<Staff> getAllStaff() {
        return this.getListStaffUseCase.execute();
    }
    public Optional<Staff> getStaffById(String id) {
        return this.getStaffUseCase.execute(id);
    }
    public List<Staff> getStaffBySpecialty(String specialty){
     return   this.findStaffBySpecialtyUseCase.find(specialty);
    }
    public Staff createStaff(Staff staff) {
        return this.saveStaffUseCase.execute(staff);
    }

    public void deleteStaff(String id) {
        this.deleteStaffUseCase.delete(id);
    }

    public Staff updateStaff(StaffDTO staffDTO, Staff existingStaff) {
                return  this.updateStaffUseCase.update(staffDTO,existingStaff);

    }




    
}