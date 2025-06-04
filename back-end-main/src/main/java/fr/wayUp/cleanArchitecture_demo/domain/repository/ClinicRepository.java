package fr.wayUp.cleanArchitecture_demo.domain.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Clinic;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ClinicDTO;
import fr.wayUp.cleanArchitecture_demo.domain.model.Service;

import java.util.List;
import java.util.Optional;

public interface ClinicRepository {
    Clinic save(Clinic clinic);
    Optional<Clinic> findById(String id);
    List<Clinic> findAll();
    List<Service> findServicesByClinicId(String clinicId);
    void deleteById(String id);
    Clinic update(ClinicDTO clinicDTO,Clinic existingClinic);

}
