package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicalTest {
    private String id;
    private String prescriptionId;
    private String type;
    private String result;
}