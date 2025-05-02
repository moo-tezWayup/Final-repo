package fr.wayUp.cleanArchitecture_demo.domain.model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class Consultation {
    private String id;
    private String patientId;
    private String doctorId;
    private LocalDateTime date;
    private String notes;
}