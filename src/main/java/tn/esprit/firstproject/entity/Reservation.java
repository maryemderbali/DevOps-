package tn.esprit.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservationn;

    private LocalDate anneeUniversitaire;
    private boolean estValide;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "reservation_etudiants",
            joinColumns = @JoinColumn(name = "reservations_id_reservationn"),
            inverseJoinColumns = @JoinColumn(name = "etudiants_id_etudiant")
    )
    private List<Etudiant> etudiants = new ArrayList<>();
}
