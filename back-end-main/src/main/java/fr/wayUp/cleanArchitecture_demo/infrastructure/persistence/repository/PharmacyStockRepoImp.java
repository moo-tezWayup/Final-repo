package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.PharmacyStock;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyStockRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.PharmacyStockMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.PharmacyStockJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PharmacyStockRepoImp implements PharmacyStockRepository {
    private final PharmacyStockJpaRepository pharmacyStockJpaRepository;
    @Override
    public PharmacyStock save(PharmacyStock pharmacyStock) {
        return  PharmacyStockMapper.toDomain(
                pharmacyStockJpaRepository.save(PharmacyStockMapper.toEntity(pharmacyStock))
        );
    }

    @Override
    public PharmacyStock update(PharmacyStock pharmacyStock) {
        return save(pharmacyStock);
    }

    @Override
    public List<PharmacyStock> findAll() {
        return pharmacyStockJpaRepository.findAll()
                .stream()
                .map(PharmacyStockMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<PharmacyStock> findById(String id) {
        return pharmacyStockJpaRepository.findById(id)
                .map(PharmacyStockMapper::toDomain);

    }

    @Override
    public void delete(String id) {
    pharmacyStockJpaRepository.deleteById(id);
    }
}
