package fac.luminy.architecture.sample.project.model.dto;

import fac.luminy.architecture.sample.project.model.TypeVoiture;
import fac.luminy.architecture.sample.project.model.entity.Voiture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe representant une voiture, utilisée pour la communication avec l'extérieur.
 *
 * @author matmiche
 */
@Setter
@Getter
@AllArgsConstructor
public class VoitureDTO {

    private Long id;
    private String modele;
    private String marque;
    private int annee;
    private TypeVoiture type;
    private int chevauxFiscaux;
    private double prix;
    private double consommation;
    private String couleur;


    public VoitureDTO(Voiture voiture) {
        if (voiture == null) return;
        this.id =  voiture.getId();
        this.modele = voiture.getModele();
        this.marque = voiture.getMarque();
        this.annee = voiture.getAnnee();
        this.type = voiture.getType();
        this.chevauxFiscaux = voiture.getChevauxFiscaux();
        this.prix = voiture.getPrix();
        this.consommation = voiture.getConsommation();
        this.couleur = voiture.getCouleur();
    }
}
