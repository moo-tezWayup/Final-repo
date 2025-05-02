package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity;

import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
    @Column(nullable = false,unique = true)
    private String cin;
    private String grade;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String phone;
    private String address;
    @Column(name = "hire_date")
    private LocalDate hireDate;
    private String imageDir ;
    private  String specialty;
  /*
    @Column(name = "in_service") private Boolean inService;
   @OneToMany(mappedBy = "responsible", cascade = CascadeType.ALL)
    private List<ServiceEntity> services;
*/
}
