package tn.esprit.firstproject.serviceIMP;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entity.Etudiant;
import tn.esprit.firstproject.repositories.EtudiantRepository;
import tn.esprit.firstproject.serviceInterface.EtudiantInterface;

import java.util.List;
@AllArgsConstructor
@Service
public class EtudiantServiceImpl implements EtudiantInterface {
    //@Autowired soit autowired soit @AllArgsConstructor
    EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
        //orElse is being used because find by id might return nothing.

    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
