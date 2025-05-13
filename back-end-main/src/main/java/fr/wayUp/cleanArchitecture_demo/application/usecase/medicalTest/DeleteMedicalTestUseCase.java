package fr.wayUp.cleanArchitecture_demo.application.usecase.medicalTest;

import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicalTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteMedicalTestUseCase {
    private  final MedicalTestRepository medicalTestRepository;
    public void delete(String id) {
        medicalTestRepository.delete(id);
    }
}
