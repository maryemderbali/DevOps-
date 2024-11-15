package tn.esprit.firstproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Chambre;
import tn.esprit.firstproject.entity.TypeChambre;
import tn.esprit.firstproject.serviceInterface.ChambreInterface;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("Chambre")
public class ChambreController {
    ChambreInterface chambreInterface;

    @GetMapping("/getChambresParNomUniversite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable("nomUniversite") String nomUniversite) {
        return chambreInterface.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("/retrieveAllChambres")
    public List<Chambre> retrieveAllChambres() {
        return chambreInterface.retrieveAllChambres();
    }
    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreInterface.addChambre(c);
    }
    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre c) {
        return chambreInterface.updateChambre(c);
    }
    @GetMapping("/retrieveChambre/{id}")
    public Chambre retrieveChambre(@PathVariable("id") Integer idChambre) {
        return chambreInterface.retrieveChambre(idChambre);
    }

    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable("idBloc") Integer idBloc,
                                                  @PathVariable("typeC") TypeChambre typeC) {
        return chambreInterface.getChambresParBlocEtType(idBloc, typeC);
    }

}
