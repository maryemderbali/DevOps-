package tn.esprit.firstproject.serviceInterface;

import tn.esprit.firstproject.entity.Etudiant;

import java.util.List;

public interface EtudiantInterface {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
}
