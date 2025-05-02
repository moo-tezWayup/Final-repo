package fr.wayUp.cleanArchitecture_demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
        public class ServiceStaff {
                private String id;
                private String serviceId;
                private String staffId;
                private LocalDateTime startDate;
                private LocalDateTime endDate;
                private String status;
        }
