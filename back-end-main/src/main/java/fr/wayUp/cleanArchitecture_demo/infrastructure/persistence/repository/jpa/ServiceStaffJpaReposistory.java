package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;

import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.ServiceStaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ServiceStaffJpaReposistory extends JpaRepository<ServiceStaffEntity, String> {
    String QUERY_FIND_STAFF_SCHEDULES = """
        SELECT s.startDate, s.endDate,s.status
        FROM ServiceStaffEntity s
        WHERE FUNCTION('DATE', s.startDate) = FUNCTION('DATE', :date)
        AND s.startDate >= :currentDateTime
        AND s.staffId = :staffId
        AND s.serviceId = :serviceId"""
      ;
    @Query(QUERY_FIND_STAFF_SCHEDULES)
    List<Object> findStaffSchedulesForService(
            LocalDate date,
            LocalDateTime currentDateTime,
            String staffId,
            String serviceId);
    @Query("SELECT DISTINCT s.staffId FROM ServiceStaffEntity s WHERE s.serviceId = :serviceId")
    List<String> findDistinctStaffIdByServiceId( String serviceId);

    @Query("SELECT s.id FROM ServiceStaffEntity s WHERE s.staffId = :staffId AND s.serviceId = :serviceId")
    Optional<String> findId(
             String staffId,
             String serviceId);
}
