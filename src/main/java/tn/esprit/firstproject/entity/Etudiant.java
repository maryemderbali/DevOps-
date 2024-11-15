package tn.esprit.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;
    private String nomEt;
    private String PrenomEt;
    private Long cin;
    private String ecole;
    private Date dateNaissance;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "etudiants")
    private List<Reservation> reservations = new ArrayList<>();
}
