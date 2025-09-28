package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.repository.DroidRepository;
import br.edu.ifsp.graphql.repository.HumanRepository;
import br.edu.ifsp.graphql.repository.StarshipRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchService {
    private final HumanRepository humanRepository = new HumanRepository();
    private final DroidRepository droidRepository = new DroidRepository();
    private final StarshipRepository starshipRepository = new StarshipRepository();

    public Character getCharacterById(String id) {
        Character human = humanRepository.findHumanById(id);
        if (human != null) return human;
        
        Character droid = droidRepository.findDroidById(id);
        if (droid != null) return droid;
        
        return null;
    }

    public List<Object> search(String text) {
        String lowerText = text.toLowerCase();
        
        Stream<Human> matchingHumans = humanRepository.findAllHumans().stream()
                .filter(h -> h.getName().toLowerCase().contains(lowerText));

        Stream<Droid> matchingDroids = droidRepository.findAllDroids().stream()
                .filter(d -> d.getName().toLowerCase().contains(lowerText));

        Stream<Starship> matchingStarships = starshipRepository.findAllStarships().stream()
                .filter(s -> s.getName().toLowerCase().contains(lowerText));

        return Stream.concat(matchingHumans, Stream.concat(matchingDroids, matchingStarships))
            .collect(Collectors.toList());
    }
}