package fr.wayUp.cleanArchitecture_demo.application.service;
import fr.wayUp.cleanArchitecture_demo.application.usecase.staff.*;
import fr.wayUp.cleanArchitecture_demo.domain.model.Staff;
import fr.wayUp.cleanArchitecture_demo.web.DTO.StaffDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class StaffService {

    private final GetListStaffUseCase getListStaffUseCase;
    private final GetStaffUseCase getStaffUseCase;
    private final SaveStaffUseCase saveStaffUseCase;
    private final DeleteStaffUseCase deleteStaffUseCase;
    private final UpdateStaffUseCase updateStaffUseCase;
    public final FindStaffBySpecialtyUseCase findStaffBySpecialtyUseCase;

    // Récupérer tous les employés
    public List<Staff> getAllStaff() {
        return this.getListStaffUseCase.execute();
    }

    // Récupérer un employé par son ID
    public Optional<Staff> getStaffById(String id) {
        return this.getStaffUseCase.execute(id);
    }

    // Récupérer les employés par spécialité
    public List<Staff> getStaffBySpecialty(String specialty) {
        return this.findStaffBySpecialtyUseCase.find(specialty);
    }

    // Créer un employé
    public Staff createStaff(Staff staff) {
        // Logique spécifique pour associer un médecin à une secrétaire ou une secrétaire à des médecins
        if ("SECRETAIRE".equals(staff.getGrade()) && staff.getMedecinIds().size() > 3) {
            throw new IllegalArgumentException("Une secrétaire ne peut être associée qu'à 3 médecins maximum.");
        }

        if ("MEDECIN".equals(staff.getGrade()) && staff.getSecretaireId() != null) {
            // Logique spécifique pour associer un médecin à une secrétaire
            // Associer un médecin à une seule secrétaire
        }

        return this.saveStaffUseCase.execute(staff);
    }

    // Supprimer un employé
    public void deleteStaff(String id) {
        this.deleteStaffUseCase.delete(id);
    }

    // Mettre à jour un employé
    public Staff updateStaff(StaffDTO staffDTO, Staff existingStaff) {
        // Mettre à jour l'employé avec les nouveaux attributs
        if ("SECRETAIRE".equals(existingStaff.getGrade()) && staffDTO.getMedecinIds() != null && staffDTO.getMedecinIds().size() > 3) {
            throw new IllegalArgumentException("Une secrétaire ne peut être associée qu'à 3 médecins maximum.");
        }

        if ("MEDECIN".equals(existingStaff.getGrade()) && staffDTO.getSecretaireId() != null) {
            // Logique pour mettre à jour l'association médecin -> secrétaire
        }

        return this.updateStaffUseCase.update(staffDTO, existingStaff);
    }
}
