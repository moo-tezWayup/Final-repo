package fr.wayUp.cleanArchitecture_demo.application.usecase.PrescriptionDetail;

import fr.wayUp.cleanArchitecture_demo.domain.model.PrescriptionDetail;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllPrescriptionDetailsUseCase {
    private final PrescriptionDetailRepository prescriptionDetailRepository;
    public List<PrescriptionDetail> execute(){
        return prescriptionDetailRepository.findAll();
    }
}
