package fr.wayUp.cleanArchitecture_demo.application.service;

import fr.wayUp.cleanArchitecture_demo.application.usecase.appointment.DeleteAppointmentUseCase;
import fr.wayUp.cleanArchitecture_demo.application.usecase.appointment.FindUnavailableSchedulesUseCase;
import fr.wayUp.cleanArchitecture_demo.application.usecase.appointment.GetListAppointmentUseCase;
import fr.wayUp.cleanArchitecture_demo.application.usecase.appointment.SaveAppointmentUseCase;
import fr.wayUp.cleanArchitecture_demo.application.usecase.clinic.GetListClinicsUseCase;
import fr.wayUp.cleanArchitecture_demo.domain.model.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final DeleteAppointmentUseCase deleteAppointmentUseCase;
    private  final SaveAppointmentUseCase saveAppointmentUseCase;
    private final FindUnavailableSchedulesUseCase findUnavailableSchedulesUseCase;
    private  final GetListAppointmentUseCase getListAppointmentUseCase;
    public Appointment saveAppointment(Appointment appointment){
        return this.saveAppointmentUseCase.create(appointment);
    }
    public List<Appointment> findAllAppointments(){
        return  this.getListAppointmentUseCase.execute();
    }
    public  boolean deleteAppointment(String id){
        return  this.deleteAppointmentUseCase.delete(id);
    }
    public List<Object[]> findUnavailableSchedules(LocalDate date,
                                                   LocalDateTime currentDateTime,
                                                   String serviceStaffId,
                                                   String patientId){
        return this.findUnavailableSchedulesUseCase.execute(date,currentDateTime,serviceStaffId,patientId);
    }
}
