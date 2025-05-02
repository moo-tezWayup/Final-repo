package fr.wayUp.cleanArchitecture_demo.web.controller;
import fr.wayUp.cleanArchitecture_demo.application.service.FileUploadService;
import fr.wayUp.cleanArchitecture_demo.application.service.StaffService;
import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.infrastructure.persistence.mapper.StaffMapper;
import fr.wayUp.cleanArchitecture_demo.web.DTO.StaffDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class StaffController {

    private final StaffService staffService;
    private final  FileUploadService fileUploadService ;

    @GetMapping
    public ResponseEntity<List<StaffDTO>> getAllStaff() {
        List<Staff> staffList = staffService.getAllStaff();
        List<Staff> staffWithFullUrls = fileUploadService.convertToDtoWithFullUrl(staffList);
        return ResponseEntity.ok(StaffMapper.staffToDTO(staffWithFullUrls));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable String id) {
        Staff staff = staffService.getStaffById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Staff not found with id: " + id));
        Staff staffWithFullUrl = fileUploadService.convertSingleWithFullUrl(staff);
        return ResponseEntity.ok(staffWithFullUrl);
    }
    @GetMapping("specialty/{specialty}")
    public ResponseEntity<List<Staff>> findStaffByGrade(@PathVariable String specialty ) {
        List<Staff> staff = staffService.getStaffBySpecialty(specialty);
        return ResponseEntity.ok(staff);
    }

    @PostMapping(value = "/addStaff", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createStaff(
            @RequestParam(value = "file",required = false) MultipartFile file,
            @ModelAttribute StaffDTO staffDTO) {

        try {
            if (file != null && !file.isEmpty()) {
                String contentType = file.getContentType();
                if (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType))
                    return ResponseEntity.badRequest().body("Only JPEG or PNG images are allowed");

            }

            Staff savedStaff = staffService.createStaff( StaffMapper.toDomain(staffDTO));
                if (file != null && !file.isEmpty()) {
                String fileName = fileUploadService.saveImage(file, savedStaff.getId(), "staff");
                savedStaff.setImageDir(fileName);
                savedStaff = staffService.createStaff(savedStaff);
            }

            return ResponseEntity.ok(savedStaff);

        } catch (IOException e) {

            return ResponseEntity.internalServerError()
                    .body("Error processing file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error creating staf : " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable String id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateStaff(
            @PathVariable("id") String id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @ModelAttribute @Valid StaffDTO staffDTO) {
        System.out.println(staffDTO);
        try {
            Optional<Staff> existingStaffOpt = staffService.getStaffById(id);
            if (existingStaffOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Staff existingStaff = existingStaffOpt.get();


            if (file != null && !file.isEmpty()) {
                String contentType = file.getContentType();
                if  (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType)) {
                    return ResponseEntity.badRequest().body("Only JPEG or PNG images are allowed");
                }


                if (existingStaff.getImageDir() != null && !existingStaff.getImageDir().isEmpty()) {
                    fileUploadService.deleteImage(existingStaff.getImageDir());
                }

                String fileName = fileUploadService.saveImage(file, existingStaff.getId(), "staff");
                existingStaff.setImageDir(fileName);
            }


            Staff updatedStaff = staffService.updateStaff(staffDTO, existingStaff);
            updatedStaff = staffService.createStaff(updatedStaff);

        return ResponseEntity.ok(updatedStaff);

        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Error processing file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of(
                                    "error", "CONSTRAINT_VIOLATION",
                                    "message", e.getMessage()
                            )
                    );
        }
    }


}


