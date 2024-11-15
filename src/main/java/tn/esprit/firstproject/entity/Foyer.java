package tn.esprit.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;
    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "foyer")
    Universite universite;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    private Set<Bloc>blocs;
}
