package fac.luminy.architecture.sample.project.model.entity;

import fac.luminy.architecture.sample.project.model.TypeVoiture;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "VOITURE")
public class Voiture {
    @Id
    @GeneratedValue
    private Long id;
    private String modele;
    private String marque;
    private int annee;
    @Enumerated(EnumType.STRING)
    private TypeVoiture type;
    private int chevauxFiscaux;
    private double prix;
    private double consommation;
    //TODO ajout pour le nouveau TP
    private String couleur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proprietaire_id")
    private Personne proprietaire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locataire_id")
    private Personne locataire;
}
