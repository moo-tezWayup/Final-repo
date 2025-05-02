package fr.wayUp.cleanArchitecture_demo.application.usecase.medicalTest;

import fr.wayUp.cleanArchitecture_demo.domain.model.MedicalTest;
import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicalTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateMedicalTestUseCase {
    private  final MedicalTestRepository medicalTestRepository;
    public MedicalTest create(MedicalTest medicalTest) {
        return medicalTestRepository.save(medicalTest);
    }
}
