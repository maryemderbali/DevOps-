package tn.esprit.firstproject.serviceIMP;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entity.Bloc;
import tn.esprit.firstproject.entity.Foyer;
import tn.esprit.firstproject.entity.Universite;
import tn.esprit.firstproject.repositories.BlocRepository;
import tn.esprit.firstproject.repositories.FoyerRepository;
import tn.esprit.firstproject.repositories.UniversiteRepository;
import tn.esprit.firstproject.serviceInterface.UniversiteInterface;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements UniversiteInterface {
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversity(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversity(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversity(Integer idUniversity) {
        return universiteRepository.findById(idUniversity).orElse(null);
    }
    @Override
    public Universite affecterFoyerAUniversite(Integer idFoyer, String nomUniversite){
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite=universiteRepository.findByNomUniversiteLike(nomUniversite);
        universite.setFoyer(f);
        return universiteRepository.save(universite);
    }

        @Override
    public Universite desaffecterFoyerAUnivrsite(Integer idUniversite) {
        Universite u=universiteRepository.findById(idUniversite).orElse(null);
        u.setFoyer(null);
        return  universiteRepository.save(u);
    }

    @Override
    public void Universite() {
        Universite universite=new Universite();
        String nomU=universite.getNomUniversite();
        //operation
        universite.setNomUniversite(nomU);
    }


}
