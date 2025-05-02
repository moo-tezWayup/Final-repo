package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa;

import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentJpaRepository  extends JpaRepository<AppointmentEntity,String> {
    String QUERY_FIND_UNAVAILABLE_SCHEDULES = """
    SELECT a.startDate, a.endDate, a.status
    FROM AppointmentEntity a
    WHERE FUNCTION('DATE', a.startDate) = FUNCTION('DATE', :date)
    AND a.startDate >= :currentDateTime
    AND (a.serviceStaffId = :serviceStaffId OR a.patientId = :patientId)
    """;

    @Query(QUERY_FIND_UNAVAILABLE_SCHEDULES)
    List<Object[]> findUnavailableSchedules(
            LocalDate date,
            LocalDateTime currentDateTime,
            String serviceStaffId,
            String patientId);
}
