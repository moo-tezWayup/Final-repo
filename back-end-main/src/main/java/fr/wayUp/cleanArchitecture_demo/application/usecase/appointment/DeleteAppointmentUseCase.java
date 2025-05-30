package fr.wayUp.cleanArchitecture_demo.application.usecase.appointment;

import fr.wayUp.cleanArchitecture_demo.domain.model.Appointment;
import fr.wayUp.cleanArchitecture_demo.domain.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    public boolean delete(String id) {
                if (appointmentRepository.findById(id).isPresent()) {
                    appointmentRepository.deleteById(id);
                    return  true;
                }
                return false;

    }
}
