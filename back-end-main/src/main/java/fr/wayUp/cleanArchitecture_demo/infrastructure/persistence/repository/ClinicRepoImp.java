package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Clinic;
import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ClinicRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ClinicEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ClinicMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ServiceMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.ClinicJpaRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.ServiceJpaRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ClinicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClinicRepoImp implements ClinicRepository {

    private final ClinicJpaRepository clinicJpaRepository;
    private final ServiceJpaRepository serviceJpaRepository;

    @Override
    public Clinic save(Clinic clinic) {
        ClinicEntity entity = ClinicMapper.toEntity(clinic);
        ClinicEntity savedEntity = clinicJpaRepository.save(entity);
        return ClinicMapper.toDomain(savedEntity);
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
    public List<Service> findServicesByClinicId(String clinicId) {
        return serviceJpaRepository.findByClinicId(clinicId)
                .stream()
                .map(ServiceMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(String id) {
        clinicJpaRepository.deleteById(id);
    }

    @Override
    public Clinic update(ClinicDTO clinicDTO, Clinic existingClinic) {
        if (clinicDTO.getName() != null) {
            existingClinic.setName(clinicDTO.getName());
        }
        if (clinicDTO.getEmail() != null) {
            existingClinic.setEmail(clinicDTO.getEmail());
        }
        if (clinicDTO.getPhone() != null) {
            existingClinic.setPhone(clinicDTO.getPhone());
        }
        if (clinicDTO.getAddress() != null) {
            existingClinic.setAddress(clinicDTO.getAddress());
        }
        if (clinicDTO.getImageDir() != null) {
            existingClinic.setImageDir(clinicDTO.getImageDir());
        }
        return this.save(existingClinic);
    }
}