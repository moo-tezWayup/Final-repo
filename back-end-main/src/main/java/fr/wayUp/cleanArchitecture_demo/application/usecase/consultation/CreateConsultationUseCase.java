package fr.wayUp.cleanArchitecture_demo.application.usecase.consultation;

import fr.wayUp.cleanArchitecture_demo.domain.model.Consultation;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ConsultationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateConsultationUseCase {
    private final ConsultationRepository consultationRepository;
    public Consultation create(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
