package fr.wayUp.cleanArchitecture_demo.application.usecase.PrescriptionDetail;

import fr.wayUp.cleanArchitecture_demo.domain.model.PrescriptionDetail;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePrescriptionDetailUseCase {
    private final PrescriptionDetailRepository prescriptionDetailRepository;
    public PrescriptionDetail create(PrescriptionDetail prescriptionDetail){
        return prescriptionDetailRepository.save(prescriptionDetail);
    }
}
