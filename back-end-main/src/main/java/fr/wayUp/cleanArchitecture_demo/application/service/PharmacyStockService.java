package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacyStock.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.PharmacyStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PharmacyStockService {
    private final CreatePharmacyStockUseCase createUseCase;
    private final GetPharmacyStockUseCase getUseCase;
    private final GetAllPharmacyStocksUseCase getAllUseCase;
    private final UpdatePharmacyStockUseCase updateUseCase;
    private final DeletePharmacyStockUseCase deleteUseCase;

    public PharmacyStock create(PharmacyStock stock) {
        return createUseCase.create(stock);
    }

    public Optional<PharmacyStock> getById(String id) {
        return getUseCase.execute(id);
    }

    public List<PharmacyStock> getAll() {
        return getAllUseCase.execute();
    }

    public PharmacyStock update(PharmacyStock stock) {
        return updateUseCase.execute(stock);
    }

    public void delete(String id) {
        deleteUseCase.delete(id);
    }
}