package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private String id;
    private String firstName;
    private String lastName;
    private String cin;
    private String grade; // "MEDECIN" ou "SECRETAIRE"
    private String email;
    private String phone;
    private String address;
    private LocalDate hireDate;
    private String imageDir;
    private String specialty;

    // 🔁 Relations internes
    private String secretaireId;            // Si médecin
    private List<String> medecinIds;      // Si secrétaire

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cin=" + cin +
                ", grade=" + grade +
                ", hireDate=" + hireDate +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
