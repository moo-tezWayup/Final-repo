package fr.wayUp.cleanArchitecture_demo.application.usecase.consultation;

import fr.wayUp.cleanArchitecture_demo.domain.model.Consultation;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ConsultationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateConsultationUseCase {
    private final ConsultationRepository consultationRepository;
    public Consultation execute(Consultation consultation) {
        return consultationRepository.update(consultation);
    }
}
