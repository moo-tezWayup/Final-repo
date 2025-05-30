package fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacy;

import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PharmacyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SavePharmacyUseCase {
    private final PharmacyRepository pharmacyRepository;

    public Pharmacy create(Pharmacy pharmacy){
           return  this.pharmacyRepository.save(pharmacy);
    }
}
