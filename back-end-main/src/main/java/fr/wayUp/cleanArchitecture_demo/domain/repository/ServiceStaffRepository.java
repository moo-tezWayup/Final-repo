package fr.wayUp.cleanArchitecture_demo.domain.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.ServiceStaff;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ServiceStaffRepository {

    List<ServiceStaff> findAllServicesStaff();
    ServiceStaff saveServiceStaff(ServiceStaff serviceStaff);
    List<Object> findStaffSchedulesForService(LocalDate date, LocalDateTime currentDateTime, String staffId, String serviceId);
    void delete(String id);
    List<String> findDistinctStaffIdByServiceId(String serviceId);
   public Optional<String> findStaffServiceId(String staffId, String serviceId);

}
