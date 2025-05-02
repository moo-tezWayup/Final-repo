package fr.wayUp.cleanArchitecture_demo.application.usecase.PrescriptionDetail;

import fr.wayUp.cleanArchitecture_demo.domain.model.PrescriptionDetail;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdatePrescriptionDetailUseCase {
    private final PrescriptionDetailRepository prescriptionDetailRepository;
    public PrescriptionDetail execute(PrescriptionDetail prescriptionDetail){
        return prescriptionDetailRepository.update(prescriptionDetail);
    }
}
