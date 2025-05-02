package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.consultation.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.Consultation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ConsultationService {


    private final CreateConsultationUseCase createConsultationUseCase;
    private final GetAllConsultationsUseCase getAllConsultationsUseCase;
    private final GetConsultationUseCase getConsultationUseCase;
    private final UpdateConsultationUseCase updateConsultationUseCase;
    private final DeleteConsultationUseCase deleteConsultationUseCase;


    public Consultation saveConsultation(Consultation consultation) {
        return createConsultationUseCase.create(consultation);
    }

    public List<Consultation> getAllConsultations() {

        return getAllConsultationsUseCase.execute();
    }

    public Optional<Consultation> getConsultationById(String id) {

        return getConsultationUseCase.execute(id);
    }

    public Consultation updateConsultation(Consultation consultation) {
        return updateConsultationUseCase.execute(consultation);
    }

    public void deleteConsultation(String id) {
        deleteConsultationUseCase.delete(id);
    }

}