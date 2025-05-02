package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class Prescription {
    private String id;
    private String consultationId;
    private LocalDateTime prescriptionDate;

}