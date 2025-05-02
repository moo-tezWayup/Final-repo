package fr.wayUp.cleanArchitecture_demo.web.controller;

import fr.wayUp.cleanArchitecture_demo.application.service.FileUploadService;
import fr.wayUp.cleanArchitecture_demo.application.service.ServiceService;
import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.domain.model.Service;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.ServiceMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ClinicDTO;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ServiceController {

    private final ServiceService serviceService;
    private final FileUploadService fileUploadService ;

    @GetMapping
    public ResponseEntity<List<ServiceDTO>> getAllService() {
        List<ServiceDTO> servicesDTOS = serviceService.getAllService()
                .stream()
                .map(ServiceMapper :: toDTO)
                .toList();
        List<ServiceDTO> clinicWithFullUrls = fileUploadService.convertToDtoWithFullUrl(servicesDTOS);
        return ResponseEntity.ok(clinicWithFullUrls);
    }
    @GetMapping("/clinic/{clinicId}")
    public ResponseEntity<List<ServiceDTO>> getServicesByClinicId(@PathVariable String clinicId) {
        List<ServiceDTO> services = serviceService.getByClinicId(clinicId)
                .stream()
                .map(ServiceMapper::toDTO)
                .collect(Collectors.toList());
        List<ServiceDTO> clinicWithFullUrls = fileUploadService.convertToDtoWithFullUrl(services);
        return ResponseEntity.ok(clinicWithFullUrls);


    }

    @GetMapping("/{id}")
    public Optional<ServiceDTO> getServiceById(@PathVariable String id) {
        return serviceService.getServiceById(id).map(ServiceMapper::toDTO);
    }

    @PostMapping(value = "/addService", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<?> createService(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @ModelAttribute @Valid ServiceDTO serviceDTO) {

        try {

            if (file != null && !file.isEmpty()) {
                String contentType = file.getContentType();
                if (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType)) {
                    return ResponseEntity.badRequest().body("Only JPEG or PNG images are allowed");
                }
            }


            Service savedService = serviceService.createService(ServiceMapper.toDomain(serviceDTO));


            if (file != null && !file.isEmpty()) {
                String fileName = fileUploadService.saveImage(file, savedService.getId(), "services");
                savedService.setImageDir(fileName);

             savedService = serviceService.createService( savedService);
            }

            return ResponseEntity.ok(savedService);

        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Error processing file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error creating service: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void  deleteService(@PathVariable String id) {
        serviceService.deleteService(id);
    }


    @PatchMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<?> patchService(
            @PathVariable("id") String id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @ModelAttribute ServiceDTO serviceDTO) {

        try {
            Optional<Service> existingServiceOpt = serviceService.getServiceById(id);
            if (existingServiceOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Service existingService = existingServiceOpt.get();

            if (file != null && !file.isEmpty()) {
                String contentType = file.getContentType();
                if ( (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType))) {
                    return ResponseEntity.badRequest().body("Only JPEG or PNG images are allowed");
                }

                if (existingService.getImageDir() != null && !existingService.getImageDir().isEmpty()) {
                    fileUploadService.deleteImage(existingService.getImageDir());
                }

                String fileName = fileUploadService.saveImage(file, existingService.getId(), "services");
                existingService.setImageDir(fileName);
            }

            Service updatedService = serviceService.updateService(serviceDTO, existingService);
            updatedService = serviceService.createService(updatedService);

            return ResponseEntity.ok(updatedService);

        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Error processing file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error updating service: " + e.getMessage());
        }
    }


}
