package fr.wayUp.cleanArchitecture_demo.web.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AppointmentDTO {
    private String id ;
    private String  serviceStaffId;
    private  String patientId;
    private String  description;
    private  String type ;
    private  String status ;
    private LocalDate date ;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
