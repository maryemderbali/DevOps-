package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Chambre;
import tn.esprit.firstproject.entity.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Integer> {
    List<Chambre> findAllByNumeroChambreIn(List<Long> numChambre);
    List<Chambre> findByBlocFoyerUniversiteNomUniversiteLike(String nom);
    List<Chambre> findByTypeCAndBlocIdBloc(TypeChambre typeChambre, Integer idBloc);
    @Query("select chambre from Chambre chambre where chambre.bloc.idBloc=:idBloc and chambre.typeC=:typeC")
    List<Chambre> findbyTypecAndidBloc(@Param("typeC") TypeChambre typeChambre, @Param("idBloc")Integer idBloc);

    List <Chambre> findByTypeCAndBlocFoyerUniversiteNomUniversiteLike(TypeChambre typeChambre, String nomUniversite);
}
