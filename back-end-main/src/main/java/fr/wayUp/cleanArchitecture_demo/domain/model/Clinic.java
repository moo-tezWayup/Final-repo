package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Clinic {
    private String id ;
    private String name;
    private String address ;
    private String phone ;
    private String email ;
    private String imageDir ;


}
