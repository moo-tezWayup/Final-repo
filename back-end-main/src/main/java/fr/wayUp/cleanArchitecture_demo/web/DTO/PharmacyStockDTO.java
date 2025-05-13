package fr.wayUp.cleanArchitecture_demo.web.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PharmacyStockDTO {

    private String id;


    private String pharmacyId;

    private String medicationId;

    @PositiveOrZero(message = "Quantity must be positive or zero")
    private Integer quantity;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime receivedDate;
}