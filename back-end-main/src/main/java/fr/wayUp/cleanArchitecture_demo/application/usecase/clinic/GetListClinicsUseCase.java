package fr.wayUp.cleanArchitecture_demo.application.usecase.clinic;

import fr.wayUp.cleanArchitecture_demo.domain.model.Clinic;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetListClinicsUseCase {
    @Autowired
    private  final ClinicRepository clinicRepository;



    public List<Clinic> execute(){
        return  this.clinicRepository.findAll();
    }
}
