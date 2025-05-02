package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository;

import fr.wayUp.cleanArchitecture_demo.domain.model.Appointment;
import fr.wayUp.cleanArchitecture_demo.domain.repository.AppointmentRepository;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity.AppointmentEntity;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.AppointmentMapper;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.repository.jpa.AppointmentJpaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public class AppointmentRepoImp implements AppointmentRepository {
    private final AppointmentJpaRepository appointmentJpaRepository;

    public AppointmentRepoImp(@Lazy AppointmentJpaRepository appointmentJpaRepository) {
        this.appointmentJpaRepository = appointmentJpaRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        AppointmentEntity appointmentEntity =  AppointmentMapper.toEntity( appointment);
        return  AppointmentMapper.toDomain( this.appointmentJpaRepository.save(appointmentEntity));
    }

    @Override
    public Optional<Appointment> findById(String id) {
        return appointmentJpaRepository.findById(id)
                .map(AppointmentMapper::toDomain);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentJpaRepository.findAll()
                .stream()
                .map(AppointmentMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(String id) {
        appointmentJpaRepository.deleteById(id);
    }
    @Override
    public List<Object[]> findUnavailableSchedules(LocalDate date,
                                                   LocalDateTime currentDateTime,
                                                   String serviceStaffId,
                                                   String patientId) {
        return  appointmentJpaRepository.findUnavailableSchedules(
                date,
                currentDateTime,
                serviceStaffId,
                patientId
        );
    }
}
