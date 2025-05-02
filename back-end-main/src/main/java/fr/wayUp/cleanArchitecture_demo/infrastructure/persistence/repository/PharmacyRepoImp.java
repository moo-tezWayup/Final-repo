package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.PharmacyEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PharmacyMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.PharmacyJpaRepository;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PharmacyDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class PharmacyRepoImp implements PharmacyRepository {
    private final PharmacyJpaRepository pharmacyJpaRepository ;

    public PharmacyRepoImp( @Lazy PharmacyJpaRepository pharmacyJpaRepository) {
        this.pharmacyJpaRepository = pharmacyJpaRepository;
    }

    @Override
    public Pharmacy save(Pharmacy pharmacy) {
        PharmacyEntity entity = PharmacyMapper.toEntity(pharmacy) ;
        return    PharmacyMapper.toDomain( this.pharmacyJpaRepository.save(entity));
    }

    @Override
    public Pharmacy save(PharmacyDTO pharmacy) {
        PharmacyEntity entity = PharmacyMapper.toEntity(pharmacy) ;
        return    PharmacyMapper.toDomain( this.pharmacyJpaRepository.save(entity));
    }

    @Override
    public List<Pharmacy> findAllPharmacies() {
        return this.pharmacyJpaRepository.findAll()
                .stream()
                .map(PharmacyMapper :: toDomain)
                .toList();
    }

    @Override
    public Optional<Pharmacy> findPharmacyById(String id) {
      Optional<PharmacyEntity> entity = this.pharmacyJpaRepository.findById(id) ;
        return entity.map(PharmacyMapper :: toDomain) ;
    }

    @Override
    public Pharmacy updatePharmacy(Pharmacy pharmacy) {
        PharmacyEntity entity = PharmacyMapper.toEntity(pharmacy) ;
        return    PharmacyMapper.toDomain( this.pharmacyJpaRepository.save(entity));
    }

    @Override
    public void deletePharmacyById(String id) {
      if( this.findPharmacyById(id).isPresent() ) {
          this.pharmacyJpaRepository.deleteById(id);
          System.out.println("delete successfully");
      }
      else {
          System.out.println("--------------------- ID does not exist ----------------");
      }

    }
}
