package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medical_test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalTestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "prescription_id")
    private String prescriptionId;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "result", columnDefinition = "TEXT")
    private String result;
}