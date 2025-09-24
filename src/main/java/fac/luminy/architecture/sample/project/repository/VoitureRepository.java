package fac.luminy.architecture.sample.project.repository;

import fac.luminy.architecture.sample.project.model.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

    List<Voiture> findByProprietaireNom(@Param("nom") String nom);

    List<Voiture> findByModele(@Param("modele") String modele);

    List<Voiture> findByPrixBetween(double prixAfter, double prixBefore);
}
