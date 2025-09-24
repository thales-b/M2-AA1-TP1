package fac.luminy.architecture.sample.project.repository;

import fac.luminy.architecture.sample.project.model.entity.Personne;
import fac.luminy.architecture.sample.project.model.entity.Voiture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VoitureRepositoryTest {

    @Autowired
    private VoitureRepository voitureRepository;

    @Autowired
    private PersonneRepository personneRepository;

    @Test
    public void testFindByProprietaireNom() {
        // Arrange
        Voiture voiture = new Voiture();

        Personne proprietaire = new Personne();
        proprietaire.setNom("Greenwood");
        voiture.setProprietaire(proprietaire);
        voiture.setMarque("Ferrari");
        personneRepository.save(proprietaire);
        voitureRepository.save(voiture);

        // Act
        List<Voiture> result = voitureRepository.findByProprietaireNom("Greenwood");

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("Greenwood", result.get(0).getProprietaire().getNom());
    }

    @Test
    public void testFindByProprietaireNom_NotFound() {
        // Act
        List<Voiture> result = voitureRepository.findByProprietaireNom("NonExistent");

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindByModele() {
        // Arrange
        Voiture voiture = new Voiture();
        voiture.setModele("Compacte");
        voitureRepository.save(voiture);

        // Act
        List<Voiture> result = voitureRepository.findByModele("Compacte");

        // Assert
        assertNotNull(result);
        assertEquals("Compacte", result.getFirst().getModele());
    }

    @Test
    public void testFindByModele_NotFound() {
        // Act
        List<Voiture> result = voitureRepository.findByModele("NonExistent");

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindByPrixBetween() {
        // Arrange
        Voiture v1 = new Voiture();
        Voiture v2 = new Voiture();
        Voiture v3 = new Voiture();
        v1.setPrix(100);
        v2.setPrix(200);
        v3.setPrix(300);
        voitureRepository.save(v1);
        voitureRepository.save(v2);
        voitureRepository.save(v3);

        // Act
        List<Voiture> result = voitureRepository.findByPrixBetween(199, 300);

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertEquals(v2.getPrix(), result.get(0).getPrix());
        assertEquals(v3.getPrix(), result.get(1).getPrix());
    }
}
