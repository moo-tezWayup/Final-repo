package fr.wayUp.cleanArchitecture_demo.application.usecase.prescription;

import fr.wayUp.cleanArchitecture_demo.domain.model.Prescription;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllPrescriptionsUseCase {
    private final PrescriptionRepository prescriptionRepository;

    public List<Prescription> execute(){
        return prescriptionRepository.findAllPrescriptions();
    }
}
