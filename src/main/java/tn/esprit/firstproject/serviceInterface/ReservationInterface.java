package tn.esprit.firstproject.serviceInterface;

import tn.esprit.firstproject.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationInterface {
    List<Reservation> retrieveAllReservation();
    Reservation addReservation (Reservation res);
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (Long idReservation);
    public Reservation ajouterReservation (Integer idChambre, Long cinEtudiant) ;
/*
    public Reservation annulerReservation (Long cinEtudiant) ;
*/
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite( LocalDate anneeUniversite, String nomUniversite) ;
}
