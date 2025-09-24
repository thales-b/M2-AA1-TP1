package fac.luminy.architecture.sample.project.service;


import fac.luminy.architecture.sample.project.model.TypeVoiture;
import fac.luminy.architecture.sample.project.model.dto.VoitureDTO;
import fac.luminy.architecture.sample.project.model.entity.Voiture;
import fac.luminy.architecture.sample.project.repository.VoitureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VoitureServiceTest {

    @Mock
    private VoitureRepository voitureRepository;

    @InjectMocks
    private VoitureService voitureService;

    @Test
    public void testGetVoitures() {
        // Arrange
        Voiture voiture1 = new Voiture();
        voiture1.setId(1L);
        voiture1.setModele("Model S");
        voiture1.setMarque("Tesla");
        voiture1.setAnnee(2020);
        voiture1.setType(TypeVoiture.SUV);
        voiture1.setChevauxFiscaux(10);
        voiture1.setPrix(80000.0);
        voiture1.setConsommation(15.0);
        voiture1.setCouleur("Red");

        Voiture voiture2 = new Voiture();
        voiture2.setId(2L);
        voiture2.setModele("Model 3");
        voiture2.setMarque("Tesla");
        voiture2.setAnnee(2021);
        voiture2.setType(TypeVoiture.BERLINE);
        voiture2.setChevauxFiscaux(8);
        voiture2.setPrix(50000.0);
        voiture2.setConsommation(10.0);
        voiture2.setCouleur("Blue");

        List<Voiture> voitures = Arrays.asList(voiture1, voiture2);
        when(voitureRepository.findByProprietaireNom("Doe")).thenReturn(voitures);

        // Act
        List<VoitureDTO> result = voitureService.recupererVoituresProprietaire("Doe");

        // Assert
        assertEquals(2, result.size());
        assertEquals(voiture1.getId(), result.get(0).getId());
        assertEquals(voiture1.getModele(), result.get(0).getModele());
        assertEquals(voiture1.getMarque(), result.get(0).getMarque());
        assertEquals(voiture1.getAnnee(), result.get(0).getAnnee());
        assertEquals(voiture1.getType(), result.get(0).getType());
        assertEquals(voiture1.getChevauxFiscaux(), result.get(0).getChevauxFiscaux());
        assertEquals(voiture1.getPrix(), result.get(0).getPrix());
        assertEquals(voiture1.getConsommation(), result.get(0).getConsommation());
        assertEquals(voiture1.getCouleur(), result.get(0).getCouleur());

        assertEquals(voiture2.getId(), result.get(1).getId());
        assertEquals(voiture2.getModele(), result.get(1).getModele());
        assertEquals(voiture2.getMarque(), result.get(1).getMarque());
        assertEquals(voiture2.getAnnee(), result.get(1).getAnnee());
        assertEquals(voiture2.getType(), result.get(1).getType());
        assertEquals(voiture2.getChevauxFiscaux(), result.get(1).getChevauxFiscaux());
        assertEquals(voiture2.getPrix(), result.get(1).getPrix());
        assertEquals(voiture2.getConsommation(), result.get(1).getConsommation());
        assertEquals(voiture2.getCouleur(), result.get(1).getCouleur());
    }

    @Test
    public void testGetVoituresWithNullList() {
        // Arrange
        when(voitureRepository.findByProprietaireNom("Doe")).thenReturn(null);

        // Act
        List<VoitureDTO> result = voitureService.recupererVoituresProprietaire("Doe");

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    public void testRecupererVoituresModele() {
        // Arrange
        Voiture v1 = new Voiture();
        v1.setModele("Compacte");
        Voiture v2 = new Voiture();
        v2.setModele("Compacte");
        when(voitureRepository.findByModele("Compacte")).thenReturn(List.of(v1, v2));

        // Act
        List<VoitureDTO> result = voitureService.recupererVoituresModele("Compacte");

        // Assert
        assertEquals(2, result.size());
        assertEquals(v1.getModele(), result.getFirst().getModele());
        assertEquals(v2.getModele(), result.get(1).getModele());
    }

    @Test
    public void testRecupererVoitureFourchettePrix() {
        // Arrange
        Voiture v1 = new Voiture();
        Voiture v2 = new Voiture();
        Voiture v3 = new Voiture();
        Voiture v4 = new Voiture();
        v1.setPrix(5000);
        v2.setPrix(9999);
        v3.setPrix(10200);
        v4.setPrix(40000);
        // Faire en sorte que seules des voitures avec un prix autour de 10,000 soient selectionnees
        when(voitureRepository.findByPrixBetween(9000, 11000)).thenReturn(List.of(v2, v3));

        // Act
        List<VoitureDTO> result = voitureService.recupererVoituresFourchettePrix(10000);

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertEquals(v2.getPrix(), result.get(0).getPrix());
        assertEquals(v3.getPrix(), result.get(1).getPrix());
    }
}
