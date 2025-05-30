package fr.wayUp.cleanArchitecture_demo.web.DTO;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Builder
public class PharmacyDTO {
    private String id ;
    private String name;
    private String address ;
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Invalid phone number")
    private String phone;
    private String medicationId;

}
