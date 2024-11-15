package tn.esprit.firstproject.repositories;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Bloc;


@Repository
public interface BlocRepository extends JpaRepository<Bloc, Integer> {

}
