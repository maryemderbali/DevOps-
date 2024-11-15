package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Foyer;
@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Integer> {
}
