package tn.esprit.firstproject.serviceIMP;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entity.Chambre;
import tn.esprit.firstproject.entity.Etudiant;
import tn.esprit.firstproject.entity.Reservation;
import tn.esprit.firstproject.repositories.ChambreRepository;
import tn.esprit.firstproject.repositories.EtudiantRepository;
import tn.esprit.firstproject.repositories.ReservationRepository;
import tn.esprit.firstproject.serviceInterface.ReservationInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationInterface {
    ReservationRepository reservationRepository;
    EtudiantRepository etudiantRepository;
    ChambreRepository chambreRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation ajouterReservation(Integer idChambre, Long cinEtudiant) {
        Chambre chambre=chambreRepository.findById(idChambre).orElse(null);
        Etudiant etudiant= etudiantRepository.findByCin(cinEtudiant);
        String numReservation=chambre.getNumeroChambre()+"-"+chambre.getBloc().getNomBloc()+"-"+etudiant.getCin();
//        Reservation reservation1 =
//                Reservation.builder()
//                        .idReservationn(numReservation)
//                        .etudiants(new ArrayList<Etudiant>())
//                        .anneeUniversitaire(LocalDate.now())
//                        .estValide(true)
//                        .build();
        Reservation  reservation1 = new Reservation();
        reservationRepository.save(reservation1);
        //affectation
        reservation1.getEtudiants().add(etudiant);
        chambre.getReservations().add(reservation1);
        return reservation1;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite) {
        return reservationRepository.recupererParBlocEtTypeChambre(nomUniversite,anneeUniversite);
    }

/*    @Override
    public Reservation annulerReservation(Long cinEtudiant) {
        Etudiant etudiant=etudiantRepository.findByCin(cinEtudiant);
        Set<Reservation> reservations=etudiant.getReservations();

    }*/

}
