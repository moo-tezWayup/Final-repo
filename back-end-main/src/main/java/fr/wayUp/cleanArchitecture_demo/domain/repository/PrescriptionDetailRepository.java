package fr.wayUp.cleanArchitecture_demo.domain.repository;
import fr.wayUp.cleanArchitecture_demo.domain.model.PrescriptionDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PrescriptionDetailRepository {
    PrescriptionDetail save(PrescriptionDetail prescriptionDetail);
    PrescriptionDetail update(PrescriptionDetail prescriptionDetail);
    List<PrescriptionDetail> findAll();
    Optional<PrescriptionDetail> findById(String id);
    void delete(String id);


}
