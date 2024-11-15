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
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBloc;

    private String nomBloc;
    private long capaciteBloc;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    private Set<Chambre> chambres;
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    Foyer foyer;

}
