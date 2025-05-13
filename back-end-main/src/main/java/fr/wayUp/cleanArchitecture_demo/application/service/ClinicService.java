package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.clinic.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.Clinic;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ClinicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClinicService {

    private final SaveClinicUseCase saveClinicUseCase ;
    private  final GetListClinicsUseCase getListClinicsUseCase;
    private  final GetByIdClinicsUseCase getByIdClinicsUseCase;
   private final UpdateClinicsUseCase updateClinicsUseCase;
   private  final DeleteClinicsUseCase deleteClinicsUseCase;


    public Clinic saveClinic(Clinic clinic){
        return  this.saveClinicUseCase.create(clinic);
    }
    public List<Clinic> findAllClinics(){
        return this.getListClinicsUseCase.execute();
    }

    public Optional<Clinic> getClinicById(String id){ return this.getByIdClinicsUseCase.execute(id);}
    public Clinic updateClinic(ClinicDTO clinicDTO,Clinic existingClinic){return  this.updateClinicsUseCase.update(clinicDTO,existingClinic);}
 public void deleteClinic(String id){
     this.deleteClinicsUseCase.delete(id);
 }
}
