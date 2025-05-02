package fr.wayUp.cleanArchitecture_demo.application.usecase.medication;

import fr.wayUp.cleanArchitecture_demo.domain.model.Medication;
import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateMedicationUseCase {
private final MedicationRepository medicationRepository;
    public Medication create(Medication medication) {
        return medicationRepository.save(medication);
    }
}
