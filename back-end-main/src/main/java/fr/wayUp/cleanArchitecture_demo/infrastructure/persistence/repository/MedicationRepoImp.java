package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Medication;
import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicationRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.MedicationEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.MedicationMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.MedicationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MedicationRepoImp implements MedicationRepository {
    private final MedicationJpaRepository jpaRepository;

    @Override
    public Medication save(Medication medication) {
        MedicationEntity entity = MedicationMapper.toEntity(medication);
        return MedicationMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Medication update(Medication medication) {
        MedicationEntity entity = MedicationMapper.toEntity(medication);
        return MedicationMapper.toDomain( jpaRepository.save(entity) );
    }

    @Override
    public List<Medication> findAll() {
        return jpaRepository.findAll().stream()
                .map(MedicationMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Medication> findById(String id) {
        return jpaRepository.findById(id)
                .map(MedicationMapper::toDomain);
    }

    @Override
    public void delete(String id) {
        jpaRepository.deleteById(id);
    }
}