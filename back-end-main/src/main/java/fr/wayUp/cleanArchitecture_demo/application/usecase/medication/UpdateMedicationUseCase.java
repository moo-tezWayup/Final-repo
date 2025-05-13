package fr.wayUp.cleanArchitecture_demo.application.usecase.medication;

import fr.wayUp.cleanArchitecture_demo.domain.model.Medication;
import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateMedicationUseCase {
    private final MedicationRepository medicationRepository;
    public Medication execute(Medication medication) {
        return medicationRepository.update(medication);
    }
}
