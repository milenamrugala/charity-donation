package pl.milenamrugala.charitydonation.service;

import org.springframework.stereotype.Service;
import pl.milenamrugala.charitydonation.model.Institution;
import pl.milenamrugala.charitydonation.repository.InstitutionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;


    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    public Institution getInstitutionById(Long id) {
        return institutionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Institution not found with id: " + id));
    }

    public Institution saveInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }

    public void deleteInstitutionById(Long id) {
        institutionRepository.deleteById(id);
    }

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }
}
