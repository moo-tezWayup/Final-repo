package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper;

import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PharmacyEntity;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PharmacyDTO;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;
@Component
public class PharmacyMapper {
    public static PharmacyEntity toEntity(Pharmacy pharmacy){
        requireNonNull(pharmacy, "Pharmacy should not be null!");
        return PharmacyEntity.builder()
                .id(pharmacy.getId())
                .medicationId(pharmacy.getMedicationId())
                .address(pharmacy.getAddress())
                .phone(pharmacy.getPhone())
                .name(pharmacy.getName())
                .build();
    }
    public static PharmacyEntity toEntity(PharmacyDTO pharmacy){
        requireNonNull(pharmacy, "PharmacyDTO should not be null!");
        return PharmacyEntity.builder()
                .id(pharmacy.getId())
                .medicationId(pharmacy.getMedicationId())
                .address(pharmacy.getAddress())
                .phone(pharmacy.getPhone())
                .name(pharmacy.getName())
                .build();
    }


    public  static  Pharmacy toDomain(PharmacyEntity pharmacy){
        requireNonNull(pharmacy, "PharmacyEntity should not be null!");
        return Pharmacy.builder()
                .id(pharmacy.getId())
                .medicationId(pharmacy.getMedicationId())
                .address(pharmacy.getAddress())
                .phone(pharmacy.getPhone())
                .name(pharmacy.getName())
                .build() ;

    }

    public  static  Pharmacy toDomain(PharmacyDTO pharmacy){
        requireNonNull(pharmacy, "PharmacyDTO should not be null!");
        return Pharmacy.builder()
                .id(pharmacy.getId())
                .medicationId(pharmacy.getMedicationId())
                .address(pharmacy.getAddress())
                .phone(pharmacy.getPhone())
                .name(pharmacy.getName())
                .build() ;
    }



    public static PharmacyDTO toDTO(PharmacyEntity pharmacy){
        requireNonNull(pharmacy, "Pharmacy Entity should not be null!");
        return  PharmacyDTO.builder()
                .id(pharmacy.getId())
                .medicationId(pharmacy.getMedicationId())
                .address(pharmacy.getAddress())
                .phone(pharmacy.getPhone())
                .name(pharmacy.getName())
                .build();
    }
    public static PharmacyDTO toDTO(Pharmacy pharmacy){
        requireNonNull(pharmacy, "Pharmacy should not be null!");
        return  PharmacyDTO.builder()
                .id(pharmacy.getId())
                .medicationId(pharmacy.getMedicationId())
                .address(pharmacy.getAddress())
                .phone(pharmacy.getPhone())
                .name(pharmacy.getName())
                .build();
    }
}
