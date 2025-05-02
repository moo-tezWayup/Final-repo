package fr.wayUp.cleanArchitecture_demo.application.usecase.consultation;

import fr.wayUp.cleanArchitecture_demo.domain.model.Consultation;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ConsultationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllConsultationsUseCase {
    private final ConsultationRepository consultationRepository;
    public List<Consultation> execute() {
        return consultationRepository.findAll();
    }
}
