package fr.wayUp.cleanArchitecture_demo.application.usecase.medication;


import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteMedicationUseCase {
    private final MedicationRepository medicationRepository;

    public void delete(String id) {
        medicationRepository.delete(id);
    }
}
