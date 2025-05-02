package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.medicalTest.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.MedicalTest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalTestService {
    private final CreateMedicalTestUseCase createUseCase;
    private final GetMedicalTestUseCase getUseCase;
    private final GetAllMedicalTestsUseCase getAllUseCase;
    private final UpdateMedicalTestUseCase updateUseCase;
    private final DeleteMedicalTestUseCase deleteUseCase;

    public MedicalTest create(MedicalTest test) {
        return createUseCase.create(test);
    }

    public Optional<MedicalTest> getById(String id) {
        return getUseCase.execute(id);
    }

    public List<MedicalTest> getAll() {
        return getAllUseCase.execute();
    }

    public MedicalTest update(MedicalTest test) {
        return updateUseCase.execute(test);
    }

    public void delete(String id) {
        deleteUseCase.delete(id);
    }
}