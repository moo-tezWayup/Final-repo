package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class PharmacyStock {
    private String id;
    private String pharmacyId;
    private String medicationId;
    private Integer quantity;
    private LocalDateTime receivedDate;
}