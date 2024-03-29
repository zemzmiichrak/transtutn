package com.transtu.tn.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transtu.tn.Entity.District;
import com.transtu.tn.Entity.Ligne;
import com.transtu.tn.Repository.LigneRepository;

@Service
public class LigneService {

    @Autowired
    private LigneRepository ligneRepository;
    @Autowired
    private DistrictService districtService;
    public List<Ligne> getAllLignes() {
        return ligneRepository.findAll();
    }

    public Ligne addLigne(String code, String label, Set<Long> districtIds) {
        if (ligneRepository.existsByCodeOrLabel(code, label)) {
            throw new IllegalArgumentException("Ligne with the same code or label already exists.");
        }

        Ligne ligne = new Ligne();
        ligne.setCode(code);
        ligne.setLabel(label);

        Set<District> districts = districtService.getDistrictsByIds(districtIds);
        ligne.setDistricts(districts);

        return ligneRepository.save(ligne);
    }

    public void deleteLigne(Long id) {
      
        if (ligneRepository.existsById(id)) {
            ligneRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Ligne not found with ID: " + id);
        }
    }

    public Ligne updateLigne(Long id, String newCode, String newLabel, Set<Long> newDistrictIds) {
        Optional<Ligne> existingLigneOptional = ligneRepository.findById(id);
        if (existingLigneOptional.isPresent()) {
            Ligne existingLigne = existingLigneOptional.get();

            existingLigne.setCode(newCode);
            existingLigne.setLabel(newLabel);

            Set<District> newDistricts = districtService.getDistrictsByIds(newDistrictIds);
            existingLigne.setDistricts(newDistricts);

            return ligneRepository.save(existingLigne);
        } else {
            throw new IllegalArgumentException("Ligne not found with ID: " + id);
        }
    }

	public Ligne getLigneById(Long ligneId) {
		// TODO Auto-generated method stub
		return null;
	}



   
}