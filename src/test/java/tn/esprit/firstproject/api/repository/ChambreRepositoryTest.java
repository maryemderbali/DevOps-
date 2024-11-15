package tn.esprit.firstproject.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.firstproject.entity.Bloc;
import tn.esprit.firstproject.entity.Chambre;
import tn.esprit.firstproject.entity.TypeChambre;
import tn.esprit.firstproject.repositories.ChambreRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
public class ChambreRepositoryTest {
    @Autowired
    private ChambreRepository chambreRepository;

    @Test
    public void ChambreRepository_Save_ReturnSavedChambre() {
        // Arrange
        Bloc bloc = Bloc.builder()
                .nomBloc("A1")
                .capaciteBloc(100)
                .build();

        Chambre chambre = Chambre.builder()
                .numeroChambre(101)
                .typeC(TypeChambre.Simple)
                .bloc(bloc)
                .build();

        // Act
        Chambre savedChambre = chambreRepository.save(chambre);

        // Assert
        assertThat(savedChambre).isNotNull();
        assertThat(savedChambre.getIdChambre()).isNotNull();
        assertThat(savedChambre.getNumeroChambre()).isEqualTo(101);
        assertThat(savedChambre.getTypeC()).isEqualTo(TypeChambre.Simple);

    }

//    @Test
//    public void ChambreRepository_FindByBlocFoyerUniversiteNomUniversiteLike_ReturnsChambres() {
//        // Arrange
//        Bloc bloc = Bloc.builder()
//                .nomBloc("A1")
//                .capaciteBloc(100)
//                .build();
//
//        Chambre chambre1 = Chambre.builder()
//                .numeroChambre(102)
//                .typeC(TypeChambre.Double)
//                .bloc(bloc)
//                .build();
//
//        Chambre chambre2 = Chambre.builder()
//                .numeroChambre(103)
//                .typeC(TypeChambre.Simple)
//                .bloc(bloc)
//                .build();
//
//        chambreRepository.saveAll(List.of(chambre1, chambre2));
//
//        // Act
//        List<Chambre> chambres = chambreRepository.findByBlocFoyerUniversiteNomUniversiteLike("Esprit University");
//
//        // Assert
//        assertThat(chambres).isNotEmpty();
//        assertThat(chambres.size()).isPositive();
//    }
 /*
    @Test
    public void ChambreRepository_FindbyTypecAndidBloc_ReturnsChambres() {
        // Arrange
        Bloc bloc = Bloc.builder()
                .nomBloc("A1")
                .capaciteBloc(100)
                .build();

        Chambre chambre = Chambre.builder()
                .numeroChambre(104)
                .typeC(TypeChambre.SINGLE)
                .bloc(bloc)
                .build();

        chambreRepository.save(chambre);

        // Act
        List<Chambre> chambres = chambreRepository.findbyTypecAndidBloc(TypeChambre.SINGLE, bloc.getIdBloc());

        // Assert
        assertThat(chambres).isNotEmpty();
        assertThat(chambres.get(0).getTypeC()).isEqualTo(TypeChambre.SINGLE);
        assertThat(chambres.get(0).getBloc().getIdBloc()).isEqualTo(bloc.getIdBloc());
    }
    */

    @Test
    public void ChambreRepository_Update_ReturnUpdatedChambre() {
        // Arrange
//        Bloc bloc = Bloc.builder()
//                .nomBloc("A1")
//                .capaciteBloc(100)
//                .build();

        Chambre chambre = Chambre.builder()
                .numeroChambre(105)
                .typeC(TypeChambre.Simple)
//              .bloc(bloc)
                .build();

        Chambre savedChambre = chambreRepository.save(chambre);

        // Update the type of chambre
        savedChambre.setTypeC(TypeChambre.Double);
        Chambre updatedChambre = chambreRepository.save(savedChambre);

        // Assert
        assertThat(updatedChambre).isNotNull();
        assertThat(updatedChambre.getTypeC()).isEqualTo(TypeChambre.Double);
        assertThat(updatedChambre.getIdChambre()).isEqualTo(savedChambre.getIdChambre());
    }

    @Test
    public void ChambreRepository_Delete_RemovesChambre() {
        // Arrange
//        Bloc bloc = Bloc.builder()
//                .nomBloc("A1")
//                .capaciteBloc(100)
//                .build();

        Chambre chambre = Chambre.builder()
                .numeroChambre(106)
                .typeC(TypeChambre.Simple)
//               .bloc(bloc)
                .build();

        Chambre savedChambre = chambreRepository.save(chambre);
        Integer chambreId = savedChambre.getIdChambre();

        // Act
        chambreRepository.deleteById(chambreId);

        // Assert
        assertThat(chambreRepository.findById(chambreId)).isNotPresent();
    }

    @Test
    public void ChambreRepository_RetrieveAllChambres_ReturnsChambres() {
        // Arrange: Create and save a few Chambre entities
        Bloc bloc = Bloc.builder()
                .nomBloc("A1")
                .capaciteBloc(100)
                .build();

        Chambre chambre1 = Chambre.builder()
                .numeroChambre(101)
                .typeC(TypeChambre.Simple)
                .bloc(bloc)
                .build();

        Chambre chambre2 = Chambre.builder()
                .numeroChambre(102)
                .typeC(TypeChambre.Double)
                .bloc(bloc)
                .build();

        // Save the chambres
        chambreRepository.saveAll(List.of(chambre1, chambre2));

        // Act: Retrieve all chambres from the repository
        List<Chambre> retrievedChambres = chambreRepository.findAll();

        // Assert: Verify the retrieved chambres
        assertThat(retrievedChambres).isNotNull();
        assertThat(retrievedChambres).hasSize(2); // Check that there are 2 chambres in the list
        assertThat(retrievedChambres.get(0).getNumeroChambre()).isEqualTo(101);
        assertThat(retrievedChambres.get(0).getTypeC()).isEqualTo(TypeChambre.Simple);
        assertThat(retrievedChambres.get(1).getNumeroChambre()).isEqualTo(102);
        assertThat(retrievedChambres.get(1).getTypeC()).isEqualTo(TypeChambre.Double);
    }

    }
