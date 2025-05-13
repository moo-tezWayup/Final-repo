package fr.wayUp.cleanArchitecture_demo.domain.repository;
import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.web.DTO.StaffDTO;

import java.util.List;
import java.util.Optional;

public interface StaffRepository {

    Staff save(Staff staff);
    List<Staff> findAllStaff();
    Optional<Staff>  findStaffById(String id);
    void  deleteStaffById(String id);
    Staff updateStaff(StaffDTO staffDTO, Staff existingStaff);
    List<Staff> findBySpecialty(String specialty);


}
