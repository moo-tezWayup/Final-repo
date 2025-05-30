package fr.wayUp.cleanArchitecture_demo.application.usecase.PrescriptionDetail;

import fr.wayUp.cleanArchitecture_demo.domain.model.PrescriptionDetail;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class DeletePrescriptionDetailUseCase {
    private final PrescriptionDetailRepository prescriptionDetailRepository;
    public void delete(String id){
         prescriptionDetailRepository.delete(id);
    }
}
