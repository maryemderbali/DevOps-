package tn.esprit.firstproject.serviceIMP;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entity.Bloc;
import tn.esprit.firstproject.entity.Foyer;
import tn.esprit.firstproject.entity.Universite;
import tn.esprit.firstproject.repositories.BlocRepository;
import tn.esprit.firstproject.repositories.FoyerRepository;
import tn.esprit.firstproject.repositories.UniversiteRepository;
import tn.esprit.firstproject.serviceInterface.FoyerInterface;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements FoyerInterface {
    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;
    BlocRepository blocRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Integer idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(Integer idFoyer) {
        foyerRepository.deleteById(idFoyer);

    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Integer idUniversite) {
        Foyer foyer1=foyerRepository.save(foyer);
        Universite universite=universiteRepository.findById(idUniversite).orElse(null);
        universite.setFoyer(foyer1);
        Set<Bloc> blocs=foyer1.getBlocs();
        for (Bloc bloc:blocs){
            bloc.setFoyer(foyer1);
            blocRepository.save(bloc);
        }
        universiteRepository.save(universite);
        return foyer1;
    }
}
