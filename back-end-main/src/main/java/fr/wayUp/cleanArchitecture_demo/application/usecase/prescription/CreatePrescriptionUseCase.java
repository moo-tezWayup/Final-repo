package fr.wayUp.cleanArchitecture_demo.application.usecase.prescription;

import fr.wayUp.cleanArchitecture_demo.domain.model.Prescription;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePrescriptionUseCase {
    private final PrescriptionRepository prescriptionRepository;

    public Prescription create(Prescription prescription){
        return prescriptionRepository.CreatePrescription(prescription);
    }
}
