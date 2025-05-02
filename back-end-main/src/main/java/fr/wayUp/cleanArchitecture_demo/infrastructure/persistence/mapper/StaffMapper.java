package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.StaffEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.StaffDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;
@Component
public class StaffMapper {
   public static Staff toDomain(StaffEntity staffEntity){
       requireNonNull(staffEntity, "staff entity should not be null!");
       return Staff.builder()
               .id(staffEntity.getId())
               .firstName(staffEntity.getFirstName())
               .lastName(staffEntity.getLastName())
               .grade(staffEntity.getGrade())
               .hireDate(staffEntity.getHireDate())
               .address(staffEntity.getAddress())
               .phone(staffEntity.getPhone())
               .email(staffEntity.getEmail())
               .cin(staffEntity.getCin())
               .imageDir(staffEntity.getImageDir())
               .Specialty(staffEntity.getSpecialty())
               .build();
   }
    public static Staff toDomain(StaffDTO staffDTO){
        requireNonNull(staffDTO  , "staff DTO should not be null!");
        return Staff.builder()
                .id(staffDTO.getId())
                .firstName(staffDTO.getFirstName())
                .lastName(staffDTO.getLastName())
                .hireDate(staffDTO.getHireDate())
                .address(staffDTO.getAddress())
                .phone(staffDTO.getPhone())
                .email(staffDTO.getEmail())
                .cin(staffDTO.getCin())
                .grade(staffDTO.getGrade())
                .imageDir(staffDTO.getImageDir())
                .Specialty(staffDTO.getSpecialty())
                .build();
    }
    public static StaffEntity toEntity(Staff staff){
        requireNonNull(staff, "staff  should not be null!");
        return StaffEntity.builder()
                .id(staff.getId())
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .hireDate(staff.getHireDate())
                .address(staff.getAddress())
                .phone(staff.getPhone())
                .email(staff.getEmail())
                .cin(staff.getCin())
                .grade(staff.getGrade())
                .imageDir(staff.getImageDir())
                .specialty(staff.getSpecialty())
                .build();
    }
    public static StaffEntity toEntity(StaffDTO staffDTO){
        requireNonNull(staffDTO, "staff DTO  should not be null!");
        return StaffEntity.builder()
                .id(staffDTO.getId())
                .firstName(staffDTO.getFirstName())
                .lastName(staffDTO.getLastName())
                .hireDate(staffDTO.getHireDate())
                .address(staffDTO.getAddress())
                .phone(staffDTO.getPhone())
                .email(staffDTO.getEmail())
                .cin(staffDTO.getCin())
                .grade(staffDTO.getGrade())
                .imageDir(staffDTO.getImageDir())
                .specialty(staffDTO.getSpecialty())
                .build();
    }
    public static StaffDTO toDTO(Staff staff){
        requireNonNull(staff, "staff  should not be null!");
        return StaffDTO.builder()
                .id(staff.getId())
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .hireDate(staff.getHireDate())
                .address(staff.getAddress())
                .phone(staff.getPhone())
                .email(staff.getEmail())
                .cin(staff.getCin())
                .grade(staff.getGrade())
                .imageDir(staff.getImageDir())
                .specialty(staff.getSpecialty())
                .build();
    }


    public static List<StaffDTO> EntityToDTO(List<StaffEntity> staff){

        return  staff.stream().map(StaffMapper::toDTO).toList() ;
    }
    public static List<StaffDTO> staffToDTO(List<Staff> staff){

        return  staff.stream().map(StaffMapper::toDTO).toList() ;
    }
    public static StaffDTO toDTO(StaffEntity staffEntity){
        requireNonNull(staffEntity, "staff entity should not be null!");
        return StaffDTO.builder()
                .id(staffEntity.getId())
                .firstName(staffEntity.getFirstName())
                .lastName(staffEntity.getLastName())
                .hireDate(staffEntity.getHireDate())
                .address(staffEntity.getAddress())
                .phone(staffEntity.getPhone())
                .email(staffEntity.getEmail())
                .grade(staffEntity.getGrade())
                .cin(staffEntity.getCin())
                .imageDir(staffEntity.getImageDir())
                .specialty(staffEntity.getSpecialty())
                .build();
    }



}
