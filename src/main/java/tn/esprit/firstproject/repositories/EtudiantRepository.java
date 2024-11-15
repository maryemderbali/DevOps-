package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Etudiant;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    Etudiant findByCin(Long cin);
}
