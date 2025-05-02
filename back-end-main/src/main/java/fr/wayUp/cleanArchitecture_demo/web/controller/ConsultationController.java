package fr.wayUp.cleanArchitecture_demo.web.controller;

import fr.wayUp.cleanArchitecture_demo.application.service.ConsultationService;
import fr.wayUp.cleanArchitecture_demo.domain.model.Consultation;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ConsultationMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ConsultationDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/consultations")
@CrossOrigin
@RequiredArgsConstructor
public class ConsultationController {
    private final ConsultationService consultationService;



    @PostMapping("/add")
    public Consultation addConsultation(@RequestBody @Valid  ConsultationDTO consultation) {
        return consultationService.saveConsultation(
                ConsultationMapper.toDomain(consultation)
        );
    }

    @GetMapping
    public List<ConsultationDTO> getAllConsultations() {
        return ConsultationMapper.consultationToDTO(consultationService.getAllConsultations());
    }

    @GetMapping("/{id}")
    public Optional<ConsultationDTO> getConsultation(@PathVariable String id) {
        return consultationService.getConsultationById(id)
                .map(ConsultationMapper::toDTO);
    }
    @PutMapping("/update")
    public Consultation updateConsultation(@RequestBody @Valid  ConsultationDTO consultation) {
        return consultationService.updateConsultation(
                ConsultationMapper.toDomain(consultation)
        );
    }

    @DeleteMapping("/delete/{id}")
    public void deleteConsultation(@PathVariable String id) {
        consultationService.deleteConsultation(id);
    }
}
