package fr.wayUp.cleanArchitecture_demo.application.usecase.PrescriptionDetail;

import fr.wayUp.cleanArchitecture_demo.domain.model.PrescriptionDetail;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetPrescriptionDetailUseCase {
    private final PrescriptionDetailRepository prescriptionDetailRepository;
    public Optional<PrescriptionDetail> execute(String id){
        return prescriptionDetailRepository.findById(id);
    }
}
