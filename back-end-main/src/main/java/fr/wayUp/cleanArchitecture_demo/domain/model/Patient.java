package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Patient {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String gender;
    private String mobile;
    private String email;
    private String imageDir ;
}