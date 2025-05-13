package fr.wayUp.cleanArchitecture_demo.web.controller;
import fr.wayUp.cleanArchitecture_demo.application.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.nio.file.NoSuchFileException;
@RestController
@RequestMapping("/static")
@RequiredArgsConstructor
@CrossOrigin
public class ImageController {
    private final FileUploadService fileUploadService ;

    @GetMapping("/images/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        try {

            if (!filename.matches(".*\\.(png|jpe?g)$")) {
                return ResponseEntity.badRequest().build();
            }



            byte[] imageBytes = fileUploadService.getImage(filename);
            String contentType = filename.endsWith(".png") ? "image/png" : "image/jpeg";

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(imageBytes);

        } catch (NoSuchFileException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
