package fac.luminy.architecture.sample.project.model.entity;

import fac.luminy.architecture.sample.project.util.Duree;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "LOCATION")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Duree duree;
    @OneToOne(mappedBy = "PERSONNE")
    @JoinColumn(name = "loueur_id", referencedColumnName = "id")
    private Personne loueur;
    @OneToOne(mappedBy = "PERSONNE")
    @JoinColumn(name = "locataire_id", referencedColumnName = "id")
    private Personne locataire;
    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;
}
