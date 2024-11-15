package tn.esprit.firstproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Foyer;
import tn.esprit.firstproject.serviceInterface.FoyerInterface;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("foyer")
public class FoyerController{
    FoyerInterface foyerInterface;

    @GetMapping("/retrieveAllFoyers")
    public List<Foyer> retrieveAllFoyers(){
        return foyerInterface.retrieveAllFoyers();
    }
    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerInterface.addFoyer(f);
    }
    @PutMapping("/updateFoyer")
    Foyer updateFoyer (@RequestBody Foyer f){
        return foyerInterface.updateFoyer(f);
    }
    @DeleteMapping("/deleteFoyer/{id}")
    void removeFoyer (@PathVariable("id") Integer idFoyer){
        foyerInterface.removeFoyer(idFoyer);
    }
    @GetMapping("/retriveFoyer/{id}")
    Foyer retrieveFoyer (@PathVariable("id") Integer idFoyer){
        return foyerInterface.retrieveFoyer(idFoyer);
    }
    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUni}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable("idUni") Integer idUniversite) {
        return foyerInterface.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }




}
