package br.edu.ifsp.graphql.repository;

import br.edu.ifsp.graphql.model.Human;
import java.util.ArrayList;
import java.util.List;

public class HumanRepository {
    private final List<Human> humans = new ArrayList<>();

    public List<Human> findAllHumans() {
        return humans;
    }

    public Human findHumanById(String id) {
        return humans.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveHuman(Human human) {
        humans.add(human);
    }

    public void updateHuman(Human human) {
        deleteHuman(human.getId());
        saveHuman(human);
    }

    public void deleteHuman(String id) {
        humans.removeIf(h -> h.getId().equals(id));
    }
}

