package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="appointment")
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "service_staff_id",nullable = false)
    private String serviceStaffId;

    @Column(name = "patient_id",nullable = false)
    private String patientId;

    @Column(name = "description")
    private String description;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")

    private LocalDateTime endDate;

}
