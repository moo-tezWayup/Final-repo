package fr.wayUp.cleanArchitecture_demo.web.DTO;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDTO {

    private String id;


    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    private String description;

    @DecimalMin(value = "0.0", message = "Price must be positive")
    @Digits(integer = 8, fraction = 2, message = "Invalid price format")
    private BigDecimal price;

    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;

    private String prescriptionDetailId;
}