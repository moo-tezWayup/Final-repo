package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;
import fr.wayUp.cleanArchitecture_demo.domain.model.MedicalTest;
import fr.wayUp.cleanArchitecture_demo.domain.repository.MedicalTestRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.MedicalTestEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.MedicalTestMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.MedicalTestJpaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicalTestRepoImp implements MedicalTestRepository {
    private final MedicalTestJpaRepository medicalTestRepo;

    public MedicalTestRepoImp(@Lazy MedicalTestJpaRepository medicalTestRepo) {
        this.medicalTestRepo = medicalTestRepo;
    }

    @Override
    public MedicalTest save(MedicalTest medicalTest) {
        return MedicalTestMapper.toDomain(medicalTestRepo.save(MedicalTestMapper.toEntity(medicalTest)));
    }

    @Override
    public MedicalTest update(MedicalTest medicalTest) {
        MedicalTestEntity entity = MedicalTestMapper.toEntity(medicalTest);
        MedicalTestEntity updatedEntity = medicalTestRepo.save(entity);
        return MedicalTestMapper.toDomain(updatedEntity);
    }

    @Override
    public List<MedicalTest> findAll() {
        return medicalTestRepo.findAll()
                .stream()
                .map(MedicalTestMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<MedicalTest> findById(String id) {
        return medicalTestRepo.findById(id)
                .map(MedicalTestMapper::toDomain);
    }

    @Override
    public void delete(String id) {
        medicalTestRepo.deleteById(id);

    }

}