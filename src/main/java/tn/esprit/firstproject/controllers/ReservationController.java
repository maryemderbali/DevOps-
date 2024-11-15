package tn.esprit.firstproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Reservation;
import tn.esprit.firstproject.serviceInterface.ReservationInterface;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("reservation")
public class ReservationController {
    ReservationInterface reservationInterface;

    @GetMapping("/retrieveAllReservation")
    public List<Reservation> retrieveAllReservation() {
        return reservationInterface.retrieveAllReservation();
    }

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation res) {
        return reservationInterface.addReservation(res);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation res) {
        return reservationInterface.updateReservation(res);
    }

    @GetMapping("/retrieveReservation/{id}")
    public Reservation retrieveReservation(@PathVariable("id") Long idReservation) {
        return reservationInterface.retrieveReservation(idReservation);
    }

    @PutMapping("/ajouterReservation/{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable("idChambre") Integer idChambre, @PathVariable("cinEtudiant") Long cinEtudiant) {
        return reservationInterface.ajouterReservation(idChambre, cinEtudiant);
    }


    @GetMapping("/getReservationKeyWord/{anneeUniversite}/{nomUniversite}")
    public List<Reservation> getReservationKeyWord(@PathVariable("anneeUniversite")
                                                   @DateTimeFormat(iso =
                                                           DateTimeFormat.ISO.DATE) LocalDate anneeUniversite,
                                                   @PathVariable("nomUniversite") String nomUniversite) {
        return reservationInterface.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
    }
}
