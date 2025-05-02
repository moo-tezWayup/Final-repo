package fr.wayUp.cleanArchitecture_demo.web.controller;

import fr.wayUp.cleanArchitecture_demo.application.service.AppointmentService;
import fr.wayUp.cleanArchitecture_demo.domain.model.Appointment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AppointmentController {
    private final AppointmentService appointmentService;
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAllAppointments());
    }
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody @Valid Appointment appointment) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentService.saveAppointment(appointment));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable String id) {
        if (!appointmentService.deleteAppointment(id)) {
            return ResponseEntity.internalServerError().body("id "+id+"  not found ");
        }
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/unavailable-schedules")
    public ResponseEntity<List<Object[]>> getUnavailableSchedules(
            @RequestParam LocalDate date,
            @RequestParam LocalDateTime currentDateTime,
            @RequestParam(required = false) String serviceStaffId,
            @RequestParam(required = false) String patientId) {

        List<Object[]> unavailableSchedules = appointmentService.findUnavailableSchedules(
                date,
                currentDateTime,
                serviceStaffId,
                patientId);

        return ResponseEntity.ok(unavailableSchedules);
    }

}
