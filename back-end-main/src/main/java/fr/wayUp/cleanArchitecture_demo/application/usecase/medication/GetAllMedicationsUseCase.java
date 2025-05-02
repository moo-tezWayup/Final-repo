package fr.wayUp.cleanArchitecture_demo.application.usecase.medication;

import fr.wayUp.cleanArchitecture_demo.domain.model.Medication;
import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetAllMedicationsUseCase {
    private final MedicationRepository medicationRepository;
    public List<Medication> execute() {
        return medicationRepository.findAll();
    }
}
