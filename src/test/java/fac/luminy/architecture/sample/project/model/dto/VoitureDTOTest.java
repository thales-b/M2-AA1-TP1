package fac.luminy.architecture.sample.project.model.dto;

import fac.luminy.architecture.sample.project.model.TypeVoiture;
import fac.luminy.architecture.sample.project.model.entity.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VoitureDTOTest {

    @Test
    public void testVoitureDTOConstructor() {
        // Creation de l'objet voiture entite
        Voiture voiture = new Voiture();
        voiture.setId(1L);
        voiture.setModele("Model S");
        voiture.setMarque("Tesla");
        voiture.setAnnee(2020);
        voiture.setType(TypeVoiture.SUV);
        voiture.setChevauxFiscaux(10);
        voiture.setPrix(80000.0);
        voiture.setConsommation(15.0);
        voiture.setCouleur("Red");

        // Convertion
        VoitureDTO voitureDTO = new VoitureDTO(voiture);

        // Assert
        assertEquals(voiture.getId(), voitureDTO.getId());
        assertEquals(voiture.getModele(), voitureDTO.getModele());
        assertEquals(voiture.getMarque(), voitureDTO.getMarque());
        assertEquals(voiture.getAnnee(), voitureDTO.getAnnee());
        assertEquals(voiture.getType(), voitureDTO.getType());
        assertEquals(voiture.getChevauxFiscaux(), voitureDTO.getChevauxFiscaux());
        assertEquals(voiture.getPrix(), voitureDTO.getPrix());
        assertEquals(voiture.getConsommation(), voitureDTO.getConsommation());
        assertEquals(voiture.getCouleur(), voitureDTO.getCouleur());
    }

    @Test
    public void testVoitureDTOConstructorCasLimite(){
        VoitureDTO voitureDTO = new VoitureDTO(null);
        assertNull(voitureDTO.getId());
        assertNull(voitureDTO.getModele());
        assertNull(voitureDTO.getMarque());
    }
}
