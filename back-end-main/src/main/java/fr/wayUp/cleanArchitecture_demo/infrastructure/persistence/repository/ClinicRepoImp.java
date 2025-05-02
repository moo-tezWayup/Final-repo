package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Clinic;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ClinicRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ClinicEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ClinicMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.ClinicJpaRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ClinicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class ClinicRepoImp implements ClinicRepository {

    private final ClinicJpaRepository clinicJpaRepository;

    public ClinicRepoImp(@Lazy ClinicJpaRepository clinicJpaRepository) {
        this.clinicJpaRepository = clinicJpaRepository;
    }



    @Override
    public Clinic save(Clinic clinic) {
        ClinicEntity savedClinic=clinicJpaRepository.save(ClinicMapper.toEntity(clinic));
        return ClinicMapper.toDomain(savedClinic);
    }

    @Override
    public Optional<Clinic> findById(String id) {
        return clinicJpaRepository.findById(id)
                .map(ClinicMapper::toDomain);

    }

    @Override
    public List<Clinic> findAll() {
        return clinicJpaRepository.findAll()
                .stream()
                .map(ClinicMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(String id) {
            this.clinicJpaRepository.deleteById(id);

    }

    @Override
    public Clinic update(ClinicDTO clinicDTO ,Clinic existingClinic) {
        if (clinicDTO.getName() != null)
            existingClinic.setName(clinicDTO.getName());
        if (clinicDTO.getEmail() != null)
            existingClinic.setEmail(clinicDTO.getEmail());
        if (clinicDTO.getPhone() != null)
            existingClinic.setPhone(clinicDTO.getPhone());
        if (clinicDTO.getAddress() != null)
            existingClinic.setAddress(clinicDTO.getAddress());

        return this.save(existingClinic);
    }

}
