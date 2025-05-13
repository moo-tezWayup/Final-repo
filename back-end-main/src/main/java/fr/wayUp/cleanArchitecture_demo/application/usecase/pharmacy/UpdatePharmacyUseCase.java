package fr.wayUp.cleanArchitecture_demo.application.usecase.pharmacy;

import fr.wayUp.cleanArchitecture_demo.domain.model.Pharmacy;
import fr.wayUp.cleanArchitecture_demo.domain.repository.PharmacyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
@RequiredArgsConstructor
public class UpdatePharmacyUseCase {
    private final GetPharmacyUseCase getPharmacyUseCase;
    private  final PharmacyRepository pharmacyRepository;

    @Transactional
    public Pharmacy update(String id ,Map<String, Object> updates) {
        Pharmacy pharmacy = getPharmacyUseCase.find(id).orElseThrow(() -> new RuntimeException("Pharmacy not found with ID: " + id));
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    if (value != null)
                        pharmacy.setName((String) value);
                    break;
                case "address":
                    if (value != null)
                        pharmacy.setAddress((String)  value);
                    break;
                case "phone":
                    if (value != null)
                        pharmacy.setPhone((String)  value);
                    break;
                case "medicationId":
                    if (value != null)
                        pharmacy.setMedicationId((String) value);
                    break;
                default:
                    throw new RuntimeException("Invalid field: " + key);
            }
        });

        return this.pharmacyRepository.updatePharmacy(pharmacy);

    }
}
