package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;


import fr.wayUp.cleanArchitecture_demo.domain.model.Prescription;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PrescriptionEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PrescriptionMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.PrescriptionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PrescriptionRepoImp implements PrescriptionRepository {

    private final PrescriptionJpaRepository jpaRepository;
    @Override
    public List<Prescription> findAllPrescriptions() {
         return jpaRepository.findAll().stream()
                .map(PrescriptionMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Prescription> findPrescriptionById(String id) {
         return jpaRepository.findById(id)
                .map(PrescriptionMapper::toDomain);
    }

    @Override
    public Prescription CreatePrescription(Prescription prescription) {
        PrescriptionEntity entity = PrescriptionMapper.toEntity(prescription);
        return PrescriptionMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Prescription update(Prescription prescription) {
        PrescriptionEntity entity = PrescriptionMapper.toEntity(prescription);
        return PrescriptionMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void deleteById(String id) {
        jpaRepository.deleteById(id);
    }
}