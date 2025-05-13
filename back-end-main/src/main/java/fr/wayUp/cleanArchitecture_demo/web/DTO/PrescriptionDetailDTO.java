package fr.wayUp.cleanArchitecture_demo.web.DTO;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDetailDTO {

    private String id;


    private String prescriptionId;

    @Size(max = 100, message = "Dosage must be less than 100 characters")
    private String dosage;

    @Size(max = 50, message = "Frequency must be less than 50 characters")
    private String frequency;

    @Size(max = 50, message = "Duration must be less than 50 characters")
    private String duration;
}