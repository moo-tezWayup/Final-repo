package fr.wayUp.cleanArchitecture_demo.application.usecase.appointment;

import fr.wayUp.cleanArchitecture_demo.domain.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FindUnavailableSchedulesUseCase {
    private final AppointmentRepository appointmentRepository;
    public List<Object[]> execute(LocalDate date,
                                                   LocalDateTime currentDateTime,
                                                   String serviceStaffId,
                                                   String patientId){
        return  this.appointmentRepository.findUnavailableSchedules(date,currentDateTime,serviceStaffId,patientId);
    }
}
