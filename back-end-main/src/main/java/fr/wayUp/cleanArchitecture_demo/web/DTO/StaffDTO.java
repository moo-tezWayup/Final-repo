package fr.wayUp.cleanArchitecture_demo.web.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.*;

@Builder
@Getter
@Setter
@ToString
public class StaffDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String cin;
    private String grade;

    @Email
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Invalid phone number")
    private String phone;

    private String address;
    private LocalDate hireDate;
    private String imageDir;
    private String specialty;

    private String secretaireId;          // Utilisé si ce staff est un médecin
    private List<String> medecinIds;     // Utilisé si ce staff est une secrétaire
}
