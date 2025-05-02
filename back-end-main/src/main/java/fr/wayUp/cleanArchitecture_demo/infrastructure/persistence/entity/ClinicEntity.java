package fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="clinic")
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ClinicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    @Column(nullable = false)
    private String name;
    private String address ;
    @Column(nullable = false,unique = true)
    private String phone ;
    @Column(nullable = false,unique = true)
    private String email ;
    @Column(name="image_dir")
    private String imageDir ;

}
