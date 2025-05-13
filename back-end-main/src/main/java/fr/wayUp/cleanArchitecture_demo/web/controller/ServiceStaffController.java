package fr.wayUp.cleanArchitecture_demo.web.controller;


import fr.wayUp.cleanArchitecture_demo.application.service.ServiceStaffService;
import fr.wayUp.cleanArchitecture_demo.domain.model.ServiceStaff;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ServiceStaffMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceStaffDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/service-staff")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ServiceStaffController {

    private final ServiceStaffService serviceStaffService;

    public ServiceStaffController(ServiceStaffService serviceStaffService) {
        this.serviceStaffService = serviceStaffService;
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<Object>> getStaffSchedulesForService(
            @RequestParam LocalDate date,
            @RequestParam  LocalDateTime currentDateTime,
            @RequestParam String staffId,
            @RequestParam String serviceId) {

        List<Object> schedules = serviceStaffService.findSchedulesForService(
                date, currentDateTime, staffId, serviceId);

        return ResponseEntity.ok(schedules);
    }

    @GetMapping
    public ResponseEntity<List<ServiceStaffDTO>> getAllServiceStaff() {
        List<ServiceStaff> serviceStaffs = serviceStaffService.findAllServiceStaff();
        return ResponseEntity.ok(ServiceStaffMapper.domainToDTO(serviceStaffs));
    }


    @GetMapping("/find-id")
    public ResponseEntity<   Optional<String> > findStaffServiceIdUseCase(
            @RequestParam String staffId,
            @RequestParam String serviceId
    ) {
        Optional<String> serviceStaffId = serviceStaffService.findStaffServiceId(staffId,serviceId);
        return ResponseEntity.ok(serviceStaffId);
    }


    @PostMapping
    public ResponseEntity<ServiceStaffDTO> createServiceStaff(@RequestBody @Valid ServiceStaffDTO serviceStaffDTO) {
        ServiceStaff serviceStaff = ServiceStaffMapper.toDomain(serviceStaffDTO);
        ServiceStaff createdService = serviceStaffService.createService(serviceStaff);
        return ResponseEntity.ok(ServiceStaffMapper.toDTO(createdService));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceStaff(@PathVariable String id) {
        serviceStaffService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/by-service/{serviceId}")
    public ResponseEntity<List<String>> getStaffByServiceId(@PathVariable String serviceId) {
        List<String> serviceStaffs = serviceStaffService.findStaffByServiceId(serviceId);
        return ResponseEntity.ok(serviceStaffs);
    }


}
