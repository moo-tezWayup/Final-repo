package fr.wayUp.cleanArchitecture_demo.application.usecase.consultation;

import fr.wayUp.cleanArchitecture_demo.domain.model.Consultation;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ConsultationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@RequiredArgsConstructor
@Component
public class GetConsultationUseCase {
    private final ConsultationRepository consultationRepository ;

    public Optional<Consultation> execute(String id) {
        return consultationRepository.findById(id);
    }
}
