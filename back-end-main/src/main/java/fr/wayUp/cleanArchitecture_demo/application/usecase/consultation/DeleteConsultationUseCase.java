package fr.wayUp.cleanArchitecture_demo.application.usecase.consultation;


import fr.wayUp.cleanArchitecture_demo.domain.repository.ConsultationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class DeleteConsultationUseCase {
    private final ConsultationRepository consultationRepository;



    public void delete(String id) {
        consultationRepository.deleteById(id);
    }
}