package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacy.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PharmacyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PharmacyService {
     final DeletePharmacyUseCase deletePharmacyUseCase ;
     final SavePharmacyUseCase savePharmacyUseCase;
     final GetPharmacyUseCase getPharmacyUseCase;
     final GetListPharmaciesUseCase getListPharmaciesUseCase;

     final UpdatePharmacyUseCase updatePharmacyUseCase;



    public Pharmacy save(Pharmacy pharmacy){
        return this.savePharmacyUseCase.create(pharmacy);
    }

    public List<Pharmacy> findAllPharmacies (){
        return  this.getListPharmaciesUseCase.execute();
    }
   public  Optional<Pharmacy> findPharmacyById(String id) {
        return this.getPharmacyUseCase.find(id);
   }
    public void  deletePharmacyById(String id){
        this.deletePharmacyUseCase.delete(id);
    }
    public  Pharmacy  updatePharmacy(String id ,Map<String, Object> updates) {
      return  this.updatePharmacyUseCase.update(id , updates);
    }
}
