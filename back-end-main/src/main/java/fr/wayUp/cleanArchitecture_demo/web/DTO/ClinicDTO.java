package fr.wayUp.cleanArchitecture_demo.web.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
@Getter
@Setter
@Builder
public class ClinicDTO {
    private String id ;
    private String name;
    private String address ;
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Invalid phone number")
    private String phone ;
    @Email(message = "Invalid email format")
    private String email ;
    private String imageDir ;




}
