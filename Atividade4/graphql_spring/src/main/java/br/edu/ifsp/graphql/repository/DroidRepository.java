package br.edu.ifsp.graphql.repository;

import br.edu.ifsp.graphql.model.Droid;
import java.util.ArrayList;
import java.util.List;

public class DroidRepository {
    private final List<Droid> droids = new ArrayList<>();

    public List<Droid> findAllDroids() {
        return droids;
    }

    public Droid findDroidById(String id) {
        return droids.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveDroid(Droid droid) {
        droids.add(droid);
    }

    public void updateDroid(Droid droid) {
        deleteDroid(droid.getId());
        saveDroid(droid);
    }

    public void deleteDroid(String id) {
        droids.removeIf(d -> d.getId().equals(id));
    }
}
