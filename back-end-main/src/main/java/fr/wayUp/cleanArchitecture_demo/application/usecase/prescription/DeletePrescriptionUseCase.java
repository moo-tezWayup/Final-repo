package fr.wayUp.cleanArchitecture_demo.application.usecase.prescription;

import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePrescriptionUseCase {
   private final PrescriptionRepository prescriptionRepository;
    public void delete(String id){
         prescriptionRepository.deleteById(id);
    }
}
