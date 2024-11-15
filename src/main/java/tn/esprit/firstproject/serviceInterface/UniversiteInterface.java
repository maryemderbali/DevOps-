package tn.esprit.firstproject.serviceInterface;

import tn.esprit.firstproject.entity.Universite;

import java.util.List;

public interface UniversiteInterface {
    List<Universite> retrieveAllUniversities();

    Universite addUniversity (Universite u);

    Universite updateUniversity (Universite u);

    Universite retrieveUniversity (Integer idUniversity);
    public Universite affecterFoyerAUniversite(Integer idFoyer, String nomUniversite);
    public Universite desaffecterFoyerAUnivrsite(Integer iduniversite);
    public void Universite();
}
