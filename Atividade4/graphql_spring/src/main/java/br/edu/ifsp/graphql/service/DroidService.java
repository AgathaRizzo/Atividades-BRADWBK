package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.repository.DroidRepository;

import java.util.List;

public class DroidService {
    private final DroidRepository repository = new DroidRepository();
    private final SearchService searchService = new SearchService();

    public Droid createDroid(String id, String name, String primaryFunction) {
        Droid droid = new Droid(id, name, List.of(), List.of(), primaryFunction);
        repository.saveDroid(droid);
        return droid;
    }

    public void deleteDroid(String id) {
        repository.deleteDroid(id);
    }
    
    public Character addFriend(String characterId, String friendId) {
        Character mainCharacter = getDroidById(characterId);
        Character friendCharacter = searchService.getCharacterById(friendId);

        if (mainCharacter == null || friendCharacter == null) {
            return null;
        }

        if (mainCharacter.getFriends() instanceof List) {
            List<Character> friends = mainCharacter.getFriends();
            if (!friends.contains(friendCharacter)) {
                ((List<Character>) friends).add(friendCharacter);
            }
        }
        
        if (mainCharacter instanceof Droid) {
        repository.updateDroid((Droid) mainCharacter);
        }

        return mainCharacter;
    }

    public Character getHero(Episode episode) {
        throw new UnsupportedOperationException("Unimplemented method 'getHero'");
    }

    public Droid getDroidById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'getDroidById'");
    }
}