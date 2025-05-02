package fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacyStock;

import fr.wayUp.cleanArchitecture_demo.domain.model.PharmacyStock;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetAllPharmacyStocksUseCase {
    private  final PharmacyStockRepository pharmacyStockRepository;
    public List<PharmacyStock> execute() {
        return pharmacyStockRepository.findAll();
    }
}
