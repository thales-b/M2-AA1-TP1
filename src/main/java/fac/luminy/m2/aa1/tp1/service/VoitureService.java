package fac.luminy.m2.aa1.tp1.service;

import fac.luminy.m2.aa1.tp1.model.dto.VoitureDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class VoitureService {

    /**
     * Récupère la liste des voitures pour un propriétaire donné.
     *
     * @param nomProprietaire le nom du propriétaire dont les voitures doivent être récupérées
     * @return une liste de {@link VoitureDTO} représentant les voitures du propriétaire
     */

    public List <VoitureDTO> recupererVoituresProprietaire(String nomProprietaire){
        log.info("Demande de recuperation des voitures pour le proprietaire avec le nom {}", nomProprietaire);
        List<VoitureDTO> listeRetour = new ArrayList<>();
        //Faire l'appel au repository pour recuperer la voiture a partir du nom du proprietaire

        // Convertir les voitures en voituresDTO

        // Retourner la liste des voitures
        log.info("{} voitures pour le proprietaire avec le nom {}",listeRetour.size(),nomProprietaire);
        return listeRetour;
    }
}
