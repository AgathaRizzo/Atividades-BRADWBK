package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;

import java.util.List;

public class HeroService {
    public Character getHero(Episode episode) {
        return new Droid(
            "2001",
            "R2-D2",
            List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
            List.of(),
            "Astromech"
        );
    }
}
