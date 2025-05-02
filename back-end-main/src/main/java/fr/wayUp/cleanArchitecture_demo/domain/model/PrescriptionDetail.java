package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionDetail {
    private String id;
    private String prescriptionId;
    private String dosage;
    private String frequency;
    private String duration;
}