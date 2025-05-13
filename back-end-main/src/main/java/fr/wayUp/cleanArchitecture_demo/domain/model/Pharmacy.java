package fr.wayUp.cleanArchitecture_demo.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Pharmacy{
private String id ;
private String medicationId;
private String name;
private String address ;
private String phone;


}
