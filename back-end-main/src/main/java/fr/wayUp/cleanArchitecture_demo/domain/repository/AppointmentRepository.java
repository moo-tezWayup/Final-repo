package fr.wayUp.cleanArchitecture_demo.domain.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
    Appointment save(Appointment appointment);
    Optional<Appointment> findById(String id);
    List<Appointment> findAll();
    void deleteById(String id);
    List<Object[]> findUnavailableSchedules(LocalDate date, LocalDateTime currentDateTime,
                             String serviceStaffId,
                             String patientId);
}
