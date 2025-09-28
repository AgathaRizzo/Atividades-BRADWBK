package br.edu.ifsp.graphql.repository;

import br.edu.ifsp.graphql.model.Starship;
import java.util.ArrayList;
import java.util.List;

public class StarshipRepository {
    private final List<Starship> starships = new ArrayList<>();

    public List<Starship> findAllStarships() {
        return starships;
    }

    public Starship findStarshipById(int id) {
        return starships.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void saveStarship(Starship starship) {
        starships.add(starship);
    }

    public void updateStarship(Starship starship) {
        deleteStarship(starship.getId());
        saveStarship(starship);
    }

    public void deleteStarship(int id) {
        starships.removeIf(s -> s.getId() == id);
    }
}

