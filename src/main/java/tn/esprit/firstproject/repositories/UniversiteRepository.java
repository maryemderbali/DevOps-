package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Universite;
@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
    Universite findByNomUniversiteLike(String nomUniversite);

}
