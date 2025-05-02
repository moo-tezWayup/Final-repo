package fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacy;

import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class GetPharmacyUseCase {
    private final PharmacyRepository pharmacyRepository;

   public Optional<Pharmacy> find(String id){
        return this.pharmacyRepository.findPharmacyById(id);
   }
}
