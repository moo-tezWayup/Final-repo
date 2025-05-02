package fr.wayUp.cleanArchitecture_demo.web.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
public class ServiceStaffDTO {
        private String id;
        private String serviceId;
        private String staffId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String status;
}
/*
status :
        - UPCOMING,     // Start date is in the future
        - ONGOING,      // Between startDate and endDate
        -  COMPLETED,    // Ended normally
        - CANCELED,     // Manually canceled
        - SUSPENDED,    // Temporarily stopped
        - EXPIRED       // Automatically ended (e.g., due date passed without manual close)
*/
