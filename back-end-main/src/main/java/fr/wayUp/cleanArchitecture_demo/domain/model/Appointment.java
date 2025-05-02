package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class Appointment {

    private String id ;
    private String serviceStaffId;
    private  String patientId;
    private String  description;
    private  String type ;
    private  String status ;
    private LocalDate date ;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


}
