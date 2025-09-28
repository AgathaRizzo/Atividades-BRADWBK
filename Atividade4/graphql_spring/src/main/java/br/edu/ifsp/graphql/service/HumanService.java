package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.repository.HumanRepository;
import java.util.List;

public class HumanService {
    
    private final HumanRepository repository = new HumanRepository();

    private final SearchService searchService = new SearchService();

    public List<Human> getAllHumans() {
        return repository.findAllHumans();
    }

    public Human getHumanById(String id) {
        return repository.findHumanById(id);
    }

    public Human createHuman(String id, String name, Float height) {
        Human human = new Human(id, name, List.of(), List.of(), height);
        repository.saveHuman(human);
        return human;
    }

    public void deleteHuman(String id) {
        repository.deleteHuman(id);
    }

    public Character addFriend(String characterId, String friendId) {
        Character mainCharacter = getHumanById(characterId);
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
        
        if (mainCharacter instanceof Human) {
            repository.updateHuman((Human) mainCharacter);
        }

        return mainCharacter;
    }
}