package fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacyStock;


import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePharmacyStockUseCase {
    private  final PharmacyStockRepository pharmacyStockRepository;
    public void delete(String id) {
         pharmacyStockRepository.delete(id);
    }
}
