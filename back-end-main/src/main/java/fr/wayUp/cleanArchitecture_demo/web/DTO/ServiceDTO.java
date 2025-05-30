package fr.wayUp.cleanArchitecture_demo.web.DTO;

import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ServiceDTO {
    private String id;
    private String name;
    private String role;
    private String description;
    private String clinicId;
    private String imageDir ;


}
