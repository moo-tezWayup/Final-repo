package fr.wayUp.cleanArchitecture_demo.application.usecase.medication;

import fr.wayUp.cleanArchitecture_demo.domain.model.Medication;
import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class GetMedicationUseCase {
    private final MedicationRepository medicationRepository;
    public Optional<Medication> execute(String id) {
        return medicationRepository.findById(id);
    }
}
