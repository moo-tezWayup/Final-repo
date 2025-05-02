package fr.wayUp.cleanArchitecture_demo.web.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class PatientDTO {
        private String id;
        private String firstName;
        private String lastName;
        private LocalDate birthdate;
        private String gender;
        @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Invalid phone number")
        private String mobile;
        @Email(message ="Invalid Email" )
        private String email;
        private String imageDir ;

}
