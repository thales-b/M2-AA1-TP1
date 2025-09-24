package fac.luminy.architecture.sample.project.util;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Embeddable
public class Duree {
    private LocalDate debut;
    private LocalDate fin;

    public LocalDate getDebut() {
        return debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public long getNombreJours() {
        return ChronoUnit.DAYS.between(debut, fin);
    }
}
