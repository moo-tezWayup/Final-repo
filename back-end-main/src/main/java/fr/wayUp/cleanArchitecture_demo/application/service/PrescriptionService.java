package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.prescription.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.Prescription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    private final CreatePrescriptionUseCase createPrescriptionUseCase;
    private final GetPrescriptionUseCase getPrescriptionUseCase;
    private final GetAllPrescriptionsUseCase getAllPrescriptionsUseCase;
    private final UpdatePrescriptionUseCase updatePrescriptionUseCase;
    private final DeletePrescriptionUseCase deletePrescriptionUseCase;

    public Prescription create(Prescription prescription) {
        return createPrescriptionUseCase.create(prescription);
    }

    public Optional<Prescription> getById(String id) {
        return getPrescriptionUseCase.execute(id);
    }

    public List<Prescription> getAll() {
        return getAllPrescriptionsUseCase.execute();
    }

    public Prescription update(Prescription prescription) {
        return updatePrescriptionUseCase.execute(prescription);
    }

    public void delete(String id) {
        deletePrescriptionUseCase.delete(id);
    }
    public List<Prescription> getByConsultationId(String consultationId) {
        return getAllPrescriptionsUseCase.execute().stream()
                .filter(prescription -> prescription.getConsultationId().equals(consultationId))
                .toList();
    }
}