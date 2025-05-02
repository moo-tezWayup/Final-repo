package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.medication.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.Medication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicationService {
    private final CreateMedicationUseCase createUseCase;
    private final GetMedicationUseCase getUseCase;
    private final GetAllMedicationsUseCase getAllUseCase;
    private final UpdateMedicationUseCase updateUseCase;
    private final DeleteMedicationUseCase deleteUseCase;

    public Medication create(Medication medication) {
        return createUseCase.create(medication);
    }

    public Optional<Medication> getById(String id) {
        return getUseCase.execute(id);
    }

    public List<Medication> getAll() {
        return getAllUseCase.execute();
    }

    public Medication update(Medication medication) {
        return updateUseCase.execute(medication);
    }

    public void delete(String id) {
        deleteUseCase.delete(id);
    }
}