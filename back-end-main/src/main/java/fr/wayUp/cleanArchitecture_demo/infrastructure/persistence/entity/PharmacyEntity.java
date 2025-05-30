package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name="pharmacy")
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class PharmacyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    @Column(name = "medication_id")
    private String medicationId;
    @Column(nullable = false)
    private String name;
    private String address ;
    @Column(nullable = false,unique = true)
    private String phone;


}
