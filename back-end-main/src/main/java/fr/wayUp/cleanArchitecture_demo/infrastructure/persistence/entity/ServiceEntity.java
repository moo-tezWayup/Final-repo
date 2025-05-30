package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity;

import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "clinic_id")
    private String clinicId;
    @Column(nullable = false)
    private String name;
    private String role;
    private String description;
    private String imageDir ;




    /*@ManyToOne
    @JoinColumn(name = "responsible_id", referencedColumnName = "id")
    private StaffEntity responsible;
     */
}

