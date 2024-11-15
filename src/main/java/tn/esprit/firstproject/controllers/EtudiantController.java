package tn.esprit.firstproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Etudiant;
import tn.esprit.firstproject.serviceInterface.EtudiantInterface;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("EtudiantC")
public class EtudiantController {
    EtudiantInterface etudiantInterface;

    @GetMapping("/retrieveAllEtudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantInterface.retrieveAllEtudiants();
    }
    @PostMapping("/addEtudiant")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        System.out.println(etudiants);
        return etudiantInterface.addEtudiants(etudiants);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return etudiantInterface.updateEtudiant(e);
    }
    @GetMapping("/getEtudiant/{id}")
    public Etudiant retrieveEtudiant(@PathVariable("id") Integer idEtudiant) {
        return etudiantInterface.retrieveEtudiant(idEtudiant);
    }
    @DeleteMapping("/deleteEtudiant/{id}")
    public void removeEtudiant(@PathVariable("id") Integer idEtudiant) {
        etudiantInterface.removeEtudiant(idEtudiant);
    }
}
