package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;
import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.StaffRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.StaffEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.StaffJpaRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.StaffDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import  fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.StaffMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class StaffRepoImp  implements StaffRepository {

    private final StaffJpaRepository staffRepo;

    public StaffRepoImp(StaffJpaRepository staffRepo) {
        this.staffRepo = staffRepo;
    }


    @Override
    public Staff save(Staff staff) {
        return  StaffMapper.toDomain(staffRepo.save(StaffMapper.toEntity(staff)));
    }

    @Override
    public List<Staff> findAllStaff() {
        return staffRepo.findAll()
                .stream()
                .map(StaffMapper :: toDomain)
                .toList();
    }

    @Override
    public Optional<Staff> findStaffById(String id) {
        return staffRepo.findById(id)
                .map(StaffMapper::toDomain);

    }
    @Override
   public  void   deleteStaffById(String id) {
        if (this.findStaffById(id).isEmpty())
            System.out.println("--------------------- ID does not exist ----------------");
        else
            staffRepo.deleteById(id);


    }

    @Override
    public Staff updateStaff(StaffDTO staffDTO, Staff existingStaff) {
        if (staffDTO.getFirstName() != null) {
            existingStaff.setFirstName(staffDTO.getFirstName());
        }
        if (staffDTO.getLastName() != null) {
            existingStaff.setLastName(staffDTO.getLastName());
        }
        if (staffDTO.getCin() != null) {
            existingStaff.setCin(staffDTO.getCin());
        }
        if (staffDTO.getGrade() != null) {
            existingStaff.setGrade(staffDTO.getGrade());
        }
        if (staffDTO.getSpecialty() != null) {
            existingStaff.setSpecialty(staffDTO.getSpecialty());
        }
        if (staffDTO.getEmail() != null) {
            existingStaff.setEmail(staffDTO.getEmail());
        }
        if (staffDTO.getPhone() != null) {
            existingStaff.setPhone(staffDTO.getPhone());
        }
        if (staffDTO.getAddress() != null) {
            existingStaff.setAddress(staffDTO.getAddress());
        }
        if (staffDTO.getHireDate() != null) {
            existingStaff.setHireDate(staffDTO.getHireDate());
        }

        return StaffMapper.toDomain(staffRepo.save(StaffMapper.toEntity(existingStaff)));
    }

    @Override
    public List<Staff> findBySpecialty(String specialty) {
        return staffRepo.findBySpecialtyAndGrade(specialty,"Doctor").stream()
                .map(StaffMapper::toDomain)
                .toList();
    }
}
