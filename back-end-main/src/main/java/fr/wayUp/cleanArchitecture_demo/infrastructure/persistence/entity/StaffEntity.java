package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String cin;

    private String grade; // "MEDECIN" ou "SECRETAIRE"

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    private String address;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    private String imageDir;

    @Column(name = "specialty")
    private String specialty;


    // Si ce staff est médecin → sa secrétaire
    @ManyToOne
    @JoinColumn(name = "secretaire_id")
    private StaffEntity secretaire;

    // Si ce staff est secrétaire → ses médecins
    @OneToMany(mappedBy = "secretaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StaffEntity> medecins = new ArrayList<>();

    // vérifier si le secrétaire a atteint la limite
    public boolean canAddMoreMedecins() {
        return medecins == null || medecins.size() < 3;
    }
}
