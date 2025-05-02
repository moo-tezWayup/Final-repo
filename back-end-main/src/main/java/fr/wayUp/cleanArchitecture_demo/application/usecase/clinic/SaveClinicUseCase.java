package fr.wayUp.cleanArchitecture_demo.application.usecase.clinic;

import fr.wayUp.cleanArchitecture_demo.domain.model.Clinic;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ClinicRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ClinicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveClinicUseCase {

    private  final ClinicRepository clinicRepository;


    public Clinic create(Clinic clinic){
        return this.clinicRepository.save(clinic);
    }
}
