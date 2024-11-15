package tn.esprit.firstproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Bloc;
import tn.esprit.firstproject.repositories.BlocRepository;
import tn.esprit.firstproject.serviceInterface.BlocInterface;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("bloc")
public class BlocController {
    BlocInterface blocInterface;
    @GetMapping("/getAllBloc")
    public List<Bloc> retrieveBlocs() {
        return blocInterface.retrieveBlocs();
    }
    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocInterface.updateBloc(bloc);
    }
    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocInterface.addBloc(bloc);
    }
    @GetMapping("/retrieveBloc/{id}")
    public Bloc retrieveBloc(@PathVariable("id") Integer idBloc) {
        return blocInterface.retrieveBloc(idBloc);
    }

    @DeleteMapping("/removeBloc/{id}")
    public void removeBloc(@PathVariable("id") Integer idBloc) {
        blocInterface.removeBloc(idBloc);
    }
    @PutMapping("/affecterChambresABloc/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre,
                                      @PathVariable("idBloc") Integer idBloc){
        return blocInterface.affecterChambresABloc(numChambre,idBloc);
    }
}