package fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacy;

import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetListPharmaciesUseCase {
    private final PharmacyRepository pharmacyRepository;


    public List<Pharmacy> execute(){
        return this.pharmacyRepository.findAllPharmacies();
    }
}
