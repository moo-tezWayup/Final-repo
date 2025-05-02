package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class Medication {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String prescriptionDetailId;
}