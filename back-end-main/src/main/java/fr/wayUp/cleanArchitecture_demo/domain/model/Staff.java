package fr.wayUp.cleanArchitecture_demo.domain.model;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Staff {
    private String id;
    private String firstName;
    private String lastName;
    private String cin;
    private String grade;
    private  String Specialty;
    private String email;
    private String phone;
    private String address;
    private LocalDate hireDate;
    private String imageDir ;


    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cin =" + cin +
                ", hireDate=" + hireDate +
                ", grade=" + grade +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}