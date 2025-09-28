package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.repository.StarshipRepository;

import java.util.List;

public class StarshipService {
    private final StarshipRepository repository = new StarshipRepository();

    public List<Starship> getAllStarships() {
        return repository.findAllStarships();
    }

    public Starship getStarshipById(int id) {
        return repository.findStarshipById(id);
    }

    public Starship createStarship(int id, String name, Float length) {
        Starship starship = new Starship(id, name, length);
        repository.saveStarship(starship);
        return starship;
    }

    public void deleteStarship(int id) {
        repository.deleteStarship(id);
    }
}
