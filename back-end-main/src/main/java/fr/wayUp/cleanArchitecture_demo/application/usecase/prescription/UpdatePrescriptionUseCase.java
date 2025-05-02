package fr.wayUp.cleanArchitecture_demo.application.usecase.prescription;

import fr.wayUp.cleanArchitecture_demo.domain.model.Prescription;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdatePrescriptionUseCase {
    private final PrescriptionRepository prescriptionRepository;

    public Prescription execute(Prescription prescription){
        return prescriptionRepository.update(prescription);
    }
}
