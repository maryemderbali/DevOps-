package tn.esprit.firstproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Universite;
import tn.esprit.firstproject.serviceInterface.UniversiteInterface;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("universite")
public class UniversiteController {


    UniversiteInterface universiteInterface;
    @GetMapping("/retrieveAllUniversities")
    public List<Universite> retrieveAllUniversities() {
        return universiteInterface.retrieveAllUniversities();
    }
    @PostMapping("/addUniversity")
    public Universite addUniversity(@RequestBody Universite u) {
        return universiteInterface.addUniversity(u);
    }
    @PutMapping("/updateUniversity")
    public Universite updateUniversity(@RequestBody Universite u) {
        return universiteInterface.updateUniversity(u);
    }

@GetMapping("/retrieveUniversity/{id}")
    public Universite retrieveUniversity(@PathVariable("id") Integer idUniversity) {
        return universiteInterface.retrieveUniversity(idUniversity);
    }
    @PutMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable("idFoyer") Integer idFoyer, @PathVariable("nomUniversite")String nomUniversite){
        return universiteInterface.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }

    @PutMapping("/desaffecterFoyerAUnivrsite/{idU}")
    public Universite desaffecterFoyerAUnivrsite(@PathVariable("idU") Integer idUniversite) {
        return universiteInterface.desaffecterFoyerAUnivrsite(idUniversite);
    }



}
