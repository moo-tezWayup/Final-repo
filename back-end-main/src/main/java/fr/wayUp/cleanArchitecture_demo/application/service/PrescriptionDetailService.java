package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.PrescriptionDetail.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.PrescriptionDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrescriptionDetailService {
    private final CreatePrescriptionDetailUseCase createUseCase;
    private final GetPrescriptionDetailUseCase getUseCase;
    private final GetAllPrescriptionDetailsUseCase getAllUseCase;
    private final UpdatePrescriptionDetailUseCase updateUseCase;
    private final DeletePrescriptionDetailUseCase deleteUseCase;

    public PrescriptionDetail create(PrescriptionDetail detail) {
        return createUseCase.create(detail);
    }

    public Optional<PrescriptionDetail> getById(String id) {
        return getUseCase.execute(id);
    }

    public List<PrescriptionDetail> getAll() {
        return getAllUseCase.execute();
    }

    public PrescriptionDetail update(PrescriptionDetail detail) {
        return updateUseCase.execute(detail);
    }

    public void delete(String id) {
        deleteUseCase.delete(id);
    }
    public List<PrescriptionDetail> getByPrescriptionId(String prescriptionId) {
        return getAllUseCase.execute().stream()
                .filter(detail -> detail.getPrescriptionId().equals(prescriptionId))
                .toList();
    }
}