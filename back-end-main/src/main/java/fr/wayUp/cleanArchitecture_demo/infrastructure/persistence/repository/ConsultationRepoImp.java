package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Consultation;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ConsultationRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ConsultationEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ConsultationMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.ConsultationJpaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class ConsultationRepoImp implements ConsultationRepository {



        private final ConsultationJpaRepository consultationRepo;

        public ConsultationRepoImp(@Lazy ConsultationJpaRepository consultationRepo) {
            this.consultationRepo = consultationRepo;
        }

        @Override
        public Consultation save(Consultation consultation) {

            ConsultationEntity entity = ConsultationMapper.toEntity(consultation);

            ConsultationEntity savedEntity = consultationRepo.save(entity);

            return ConsultationMapper.toDomain(savedEntity);
        }

        @Override
        public List<Consultation> findAll() {
            return consultationRepo.findAll()
                    .stream()
                    .map(ConsultationMapper::toDomain)
                    .collect(Collectors.toList());
        }

        @Override
        public Optional<Consultation> findById(String id) {
            return consultationRepo.findById(id)
                    .map(ConsultationMapper::toDomain);
        }
        @Override
        public Consultation update(Consultation consultation) {
            ConsultationEntity entity = ConsultationMapper.toEntity(consultation);
            ConsultationEntity updatedEntity = consultationRepo.save(entity);
            return ConsultationMapper.toDomain(updatedEntity);
        }

        @Override
        public void deleteById(String id) {
            consultationRepo.deleteById(id);
        }
    }

