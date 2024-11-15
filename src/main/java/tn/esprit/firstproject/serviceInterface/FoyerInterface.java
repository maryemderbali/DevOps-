package tn.esprit.firstproject.serviceInterface;

import tn.esprit.firstproject.entity.Foyer;

import java.util.List;

public interface FoyerInterface {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer (Foyer f);

    Foyer updateFoyer (Foyer f);

    Foyer retrieveFoyer (Integer idFoyer);

    void removeFoyer (Integer idFoyer);
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, Integer idUniversite) ;
}
