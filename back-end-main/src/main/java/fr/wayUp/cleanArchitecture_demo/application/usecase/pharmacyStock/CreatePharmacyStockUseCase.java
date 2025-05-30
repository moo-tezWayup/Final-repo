package fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacyStock;

import fr.wayUp.cleanArchitecture_demo.domain.model.PharmacyStock;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePharmacyStockUseCase {
    private  final PharmacyStockRepository pharmacyStockRepository;
    public PharmacyStock create(PharmacyStock pharmacyStock) {
        return pharmacyStockRepository.save(pharmacyStock);
    }
}
