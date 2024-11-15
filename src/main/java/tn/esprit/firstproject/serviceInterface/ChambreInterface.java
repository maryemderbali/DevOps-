package tn.esprit.firstproject.serviceInterface;

import tn.esprit.firstproject.entity.Bloc;
import tn.esprit.firstproject.entity.Chambre;
import tn.esprit.firstproject.entity.TypeChambre;

import java.util.List;

public interface ChambreInterface {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c); // ajouter l’équipe avec son détail

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (Integer idChambre);
    public List<Chambre> getChambresParNomUniversite( String nomUniversite) ;
    public List<Chambre> getChambresParBlocEtType(Integer idBloc, TypeChambre typeC) ;
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            String nomUniversite,TypeChambre type);
}
