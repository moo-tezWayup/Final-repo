package fr.wayUp.cleanArchitecture_demo.application.service;
import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ClinicDTO;
import fr.wayUp.cleanArchitecture_demo.web.DTO.PatientDTO;
import fr.wayUp.cleanArchitecture_demo.web.DTO.ServiceDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class FileUploadService {
    public interface HasImageDir {
        String getImageDir();
        void setImageDir(String imageDir);
    }
    @Value("${file.upload-dir}")
    private  String uploadDir;
    @Value("${file.server-url}")
    private    String serverUrl  ;

    private static final List<String> ALLOWED_CONTENT_TYPES = List.of("image/jpeg", "image/png");
    private static final String IMAGES_URL_PATH = "/static/images/";

    public <T > List<T> convertToDtoWithFullUrl(List<T> entityList) {
        if (serverUrl == null) {
            throw new IllegalStateException("Server URL is not configured");
        }
        if (entityList == null) {
            return Collections.emptyList();
        }

        return entityList.stream()
                .map(this::convertSingleWithFullUrl)
                .collect(Collectors.toList());
    }

    public <T> T convertSingleWithFullUrl(T entity) {
        if (entity == null) {
            return null;
        }

        if (entity instanceof ClinicDTO clinic  ) {
            String imageDir = clinic.getImageDir();
            if (imageDir != null && !imageDir.startsWith("http")) {
                clinic.setImageDir(serverUrl + IMAGES_URL_PATH + imageDir);
            }
        }

        if (entity instanceof Staff staff  ) {
            String imageDir = staff.getImageDir();
            if (imageDir != null && !imageDir.startsWith("http")) {
                staff.setImageDir(serverUrl + IMAGES_URL_PATH + imageDir);
            }
        }
        if (entity instanceof ServiceDTO service  ) {
            String imageDir = service.getImageDir();
            if (imageDir != null && !imageDir.startsWith("http")) {
                service.setImageDir(serverUrl + IMAGES_URL_PATH + imageDir);
            }
        }
        if (entity instanceof PatientDTO Patient  ) {
                String imageDir = Patient.getImageDir();
                if (imageDir != null && !imageDir.startsWith("http")) {
                    Patient.setImageDir(serverUrl + IMAGES_URL_PATH + imageDir);
                }
            }
        if (entity instanceof ClinicDTO clinic  ) {
                String imageDir = clinic.getImageDir();
                if (imageDir != null && !imageDir.startsWith("http")) {
                    clinic.setImageDir(serverUrl + IMAGES_URL_PATH + imageDir);
                }
            }



        return entity;
    }
    @Async
    public String saveImage(MultipartFile file, String id, String folderName) throws IOException {
        validateFileContentType(file);
        Path uploadPath = Paths.get( uploadDir,folderName);
        createDirectoryIfNotExists(uploadPath);
        String fileName = generateFileName(file, id,folderName);
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    private void validateFileContentType(MultipartFile file) {
        String contentType = file.getContentType();
        if (!ALLOWED_CONTENT_TYPES.contains(contentType)) {
            throw new IllegalArgumentException("Only JPEG or PNG images are allowed");
        }
    }

    private void createDirectoryIfNotExists(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    private String generateFileName(MultipartFile file, String id, String prefix) {
        String originalFileName = Objects.requireNonNull(file.getOriginalFilename());
        String fileExtension = "";

        if (originalFileName.contains(".")) {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }

        return
                sanitizeName(prefix) + "_"
                +id
                + fileExtension.toLowerCase();
    }

    private String sanitizeName(String name) {
        return name.replaceAll("\\s+", "_");
    }



    public byte[] getImage(String fileName) throws IOException {
        int index= fileName.indexOf("_");
        String subFolder=(fileName.substring(0,index));
        Path filePath = Paths.get(uploadDir,subFolder, fileName);
        return Files.readAllBytes(filePath);

    }
    @Async
    public void deleteImage(String fileName){

        if (fileName == null || fileName.isEmpty())
                return;
        int index= fileName.indexOf("_");
        String subFolder=(fileName.substring(0,index));
        Path path = Paths.get(uploadDir,subFolder,fileName);
        try {
            Files.delete(path);
            System.out.println("File deleted successfully.");
        } catch (NoSuchFileException e) {
            System.out.println("File does not exist.");
        } catch (IOException e) {
            System.out.println("An error occurred while attempting to delete the file. " + e.getMessage());
        }

    }
}
