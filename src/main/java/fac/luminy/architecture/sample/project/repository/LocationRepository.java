package fac.luminy.architecture.sample.project.repository;

import fac.luminy.architecture.sample.project.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("""
    SELECT SUM(v.prix * (
        DATEDIFF('day', d.debut, d.fin)
    ))
    FROM LOCATION l
    JOIN l.voiture v
    JOIN v.proprietaire p
    JOIN l.duree d
    WHERE p.nom = :nomProprietaire
""")
    double calculateTauxAnnuelLocation(@Param("nom") String nom);
}
