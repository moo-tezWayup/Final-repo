package fr.wayUp.cleanArchitecture_demo.application.usecase.appointment;
import fr.wayUp.cleanArchitecture_demo.domain.model.Appointment;
import fr.wayUp.cleanArchitecture_demo.domain.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class GetListAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> execute(){
        return appointmentRepository.findAll();
    }
}
