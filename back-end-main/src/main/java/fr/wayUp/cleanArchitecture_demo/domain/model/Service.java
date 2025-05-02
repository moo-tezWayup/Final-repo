package fr.wayUp.cleanArchitecture_demo.domain.model;


import jakarta.persistence.Column;
import lombok.*;

@Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Service {
    private String id;
    private String clinicId;
    private String name;
    private String role;
    private String description;
    private String imageDir ;


}
