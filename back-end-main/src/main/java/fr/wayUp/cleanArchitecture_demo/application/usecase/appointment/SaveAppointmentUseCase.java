package fr.wayUp.cleanArchitecture_demo.application.usecase.appointment;

import fr.wayUp.cleanArchitecture_demo.domain.model.Appointment;
import fr.wayUp.cleanArchitecture_demo.domain.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;
    public Appointment create(Appointment appointment){
        return this.appointmentRepository.save(appointment);
    }
}
