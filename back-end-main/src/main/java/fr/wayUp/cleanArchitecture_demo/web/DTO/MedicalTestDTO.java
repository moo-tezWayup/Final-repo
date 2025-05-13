package fr.wayUp.cleanArchitecture_demo.web.DTO;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalTestDTO {
    private String id;

    private String prescriptionId;

    @Size(max = 100, message = "Test type must be less than 100 characters")
    private String type;

    private String result;
}