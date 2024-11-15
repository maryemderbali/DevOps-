package tn.esprit.firstproject.serviceInterface;

import tn.esprit.firstproject.entity.Bloc;

import java.util.List;

public interface BlocInterface {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc (Bloc bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (Integer idBloc);

    void removeBloc (Integer idBloc);
    public Bloc affecterChambresABloc(List<Long> numChambre, Integer idBloc) ;

}
