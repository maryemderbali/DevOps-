package tn.esprit.firstproject.serviceIMP;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entity.Bloc;
import tn.esprit.firstproject.entity.Chambre;
import tn.esprit.firstproject.repositories.BlocRepository;
import tn.esprit.firstproject.repositories.ChambreRepository;
import tn.esprit.firstproject.serviceInterface.BlocInterface;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocServiceImpl implements BlocInterface {
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(Integer idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Integer idBloc) {
    blocRepository.deleteById(idBloc);
    }



    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, Integer idBloc) {
        List< Chambre> chambres=chambreRepository.findAllByNumeroChambreIn(numChambre);
        Bloc b= blocRepository.findById(idBloc).orElse(null);
        for (Chambre chambre:chambres){
            chambre.setBloc(b);
            chambreRepository.save(chambre);
        }
        return b;
     }

}
