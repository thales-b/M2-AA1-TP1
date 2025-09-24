package fac.luminy.architecture.sample.project.repository;

import fac.luminy.architecture.sample.project.model.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
