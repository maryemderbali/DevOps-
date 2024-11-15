package tn.esprit.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChambre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany
    private Set<Reservation> reservations = new HashSet<>();

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    Bloc bloc;
}
