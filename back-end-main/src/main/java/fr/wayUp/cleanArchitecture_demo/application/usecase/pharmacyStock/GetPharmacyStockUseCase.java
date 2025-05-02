package fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacyStock;

import fr.wayUp.cleanArchitecture_demo.domain.model.PharmacyStock;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetPharmacyStockUseCase {
    private  final PharmacyStockRepository pharmacyStockRepository;
    public Optional<PharmacyStock> execute(String id) {
        return pharmacyStockRepository.findById(id);
    }
}
