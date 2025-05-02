package fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacy;

import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePharmacyUseCase {
    private final PharmacyRepository pharmacyRepository;


    public void delete(String id){
        pharmacyRepository.deletePharmacyById(id);
    }
}
