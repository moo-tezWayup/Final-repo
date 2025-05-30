package fr.wayUp.cleanArchitecture_demo.domain.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PharmacyDTO;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PharmacyRepository {
    Pharmacy save(Pharmacy pharmacy);
    Pharmacy save(PharmacyDTO pharmacy);
    List<Pharmacy> findAllPharmacies ();
    Optional<Pharmacy> findPharmacyById(String id);
    Pharmacy updatePharmacy(Pharmacy pharmacy);
    void  deletePharmacyById(String id);

}
