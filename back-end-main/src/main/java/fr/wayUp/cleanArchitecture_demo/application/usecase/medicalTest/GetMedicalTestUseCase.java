package fr.wayUp.cleanArchitecture_demo.application.usecase.medicalTest;

import fr.wayUp.cleanArchitecture_demo.domain.model.MedicalTest;
import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicalTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class GetMedicalTestUseCase {
    private  final MedicalTestRepository medicalTestRepository;
    public Optional<MedicalTest> execute(String id) {
        return medicalTestRepository.findById(id) ;
    }
}
