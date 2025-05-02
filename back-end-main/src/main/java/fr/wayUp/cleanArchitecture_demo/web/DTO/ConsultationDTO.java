package fr.wayUp.cleanArchitecture_demo.web.DTO;

import jakarta.validation.constraints.Future;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class ConsultationDTO {
    private String id;
    private String patientId;
    private String doctorId;
    @Future
    private LocalDateTime date;
    private String notes;
}
