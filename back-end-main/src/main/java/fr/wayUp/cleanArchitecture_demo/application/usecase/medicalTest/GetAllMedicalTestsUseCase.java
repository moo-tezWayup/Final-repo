package fr.wayUp.cleanArchitecture_demo.application.usecase.medicalTest;

import fr.wayUp.cleanArchitecture_demo.domain.model.MedicalTest;
import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicalTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetAllMedicalTestsUseCase {
    private  final MedicalTestRepository medicalTestRepository;
    public List<MedicalTest> execute( ) {
        return medicalTestRepository.findAll() ;
    }
}
