package fac.luminy.architecture.sample.project.service;

import fac.luminy.architecture.sample.project.model.dto.VoitureDTO;
import fac.luminy.architecture.sample.project.model.entity.Voiture;
import fac.luminy.architecture.sample.project.repository.VoitureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@AllArgsConstructor
public class VoitureService {
    @Autowired
    private VoitureRepository repository;

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
        List<Voiture> voituresProprietaire = repository.findByProprietaireNom(nomProprietaire);
        // Convertir les voitures en voituresDTO
        listeRetour = (voituresProprietaire == null) ? listeRetour
                :voituresProprietaire.stream().map(VoitureDTO::new).collect(Collectors.toList());
        // Retourner la liste des voitures
        log.info("{} voitures pour le proprietaire avec le nom {}",listeRetour.size(),nomProprietaire);
        return listeRetour;
    }

    public List<VoitureDTO> recupererVoituresModele(String modele){
        log.info("Demande de recuperation des voitures du modele {}", modele);
        List<VoitureDTO> listeRetour = new ArrayList<>();
        List<Voiture> voituresModele = repository.findByModele(modele);
        listeRetour = (voituresModele == null) ? listeRetour
                : voituresModele.stream().map(VoitureDTO::new).collect(Collectors.toList());
        log.info("{} voitures pour le proprietaire avec pour modele {}", listeRetour.size(),modele);
        return listeRetour;
    }

    public List<VoitureDTO> recupererVoituresFourchettePrix(double prix){
        log.info("Demande de recuperation des voitures du prix {}", prix);
        List<VoitureDTO> listeRetour = new ArrayList<>();
        double prixMin = prix - 0.1 * prix;
        double prixMax = prix + 0.1 * prix;
        List<Voiture> voitures = repository.findByPrixBetween(prixMin, prixMax);
        listeRetour = (voitures == null) ? listeRetour : voitures.stream().map(VoitureDTO::new).collect(Collectors.toList());
        return listeRetour;
    }
}
