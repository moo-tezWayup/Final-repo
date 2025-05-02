package fr.wayUp.cleanArchitecture_demo.application.usecase.prescription;

import fr.wayUp.cleanArchitecture_demo.domain.model.Prescription;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetPrescriptionUseCase {
    private final PrescriptionRepository prescriptionRepository;

    public Optional<Prescription> execute(String id){
        return prescriptionRepository.findPrescriptionById(id);
    }
}
