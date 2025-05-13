package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;
import fr.wayUp.cleanArchitecture_demo.domain.model.PrescriptionDetail;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PrescriptionDetailRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PrescriptionDetailEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PrescriptionDetailMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.PrescriptionDetailJpaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrescriptionDetailRepoImp implements PrescriptionDetailRepository {
    private final PrescriptionDetailJpaRepository prescriptionDetailRepo;

    public PrescriptionDetailRepoImp(@Lazy PrescriptionDetailJpaRepository prescriptionDetailRepo) {
        this.prescriptionDetailRepo = prescriptionDetailRepo;
    }

    @Override
    public PrescriptionDetail save(PrescriptionDetail prescriptionDetail) {
        return PrescriptionDetailMapper.toDomain(
                prescriptionDetailRepo.save(
                        PrescriptionDetailMapper.toEntity(prescriptionDetail)
                )
        );
    }

    @Override
    public PrescriptionDetail update(PrescriptionDetail prescriptionDetail) {
        PrescriptionDetailEntity entity = PrescriptionDetailMapper.toEntity(prescriptionDetail);
        PrescriptionDetailEntity updatedEntity = prescriptionDetailRepo.save(entity);
        return PrescriptionDetailMapper.toDomain(updatedEntity);
    }

    @Override
    public List<PrescriptionDetail> findAll() {
        return prescriptionDetailRepo.findAll()
                .stream()
                .map(PrescriptionDetailMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<PrescriptionDetail> findById(String id) {
        return prescriptionDetailRepo.findById(id)
                .map(PrescriptionDetailMapper::toDomain);
    }

    @Override
    public void delete(String id) {
        prescriptionDetailRepo.deleteById(id);
    }
}