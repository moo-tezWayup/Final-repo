package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.ServiceStaff;
import fr.wayUp.cleanArchitecture_demo.domain.repository.ServiceStaffRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ServiceStaffEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ServiceStaffMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.ServiceStaffJpaReposistory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ServiceStaffRepoImp  implements ServiceStaffRepository {
    private final  ServiceStaffJpaReposistory serviceStaffJpaReposistory;

    public ServiceStaffRepoImp(ServiceStaffJpaReposistory serviceStaffJpaReposistory) {
        this.serviceStaffJpaReposistory = serviceStaffJpaReposistory;
    }

    @Override
    public List<ServiceStaff> findAllServicesStaff() {
        return serviceStaffJpaReposistory.findAll()
                .stream()
                .map(ServiceStaffMapper::toDomain)
                .toList();
    }

    @Override
    public ServiceStaff saveServiceStaff(ServiceStaff serviceStaff) {
        ServiceStaffEntity serviceStaffEntity = ServiceStaffMapper.toEntity(serviceStaff);
        return ServiceStaffMapper.toDomain( serviceStaffJpaReposistory.save(serviceStaffEntity) );
    }

    @Override
    public List<Object> findStaffSchedulesForService(LocalDate date, LocalDateTime currentDateTime, String staffId, String serviceId) {
        return serviceStaffJpaReposistory.findStaffSchedulesForService(date,currentDateTime,staffId,serviceId);

    }

    @Override
    public void delete(String id) {
         serviceStaffJpaReposistory.deleteById(id);
    }

    @Override
    public List<String> findDistinctStaffIdByServiceId(String serviceId) {
        return  this.serviceStaffJpaReposistory.findDistinctStaffIdByServiceId(serviceId);
    }
    @Override
    public Optional<String> findStaffServiceId(String staffId, String serviceId){
        return this.serviceStaffJpaReposistory.findId(staffId,serviceId);
    }

}
