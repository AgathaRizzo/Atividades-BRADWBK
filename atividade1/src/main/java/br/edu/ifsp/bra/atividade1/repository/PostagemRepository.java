package br.edu.ifsp.bra.atividade1.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import br.edu.ifsp.bra.atividade1.model.Postagem;

@Component
public class PostagemRepository {
    private List<Postagem> database;

    public PostagemRepository() {
        database = new ArrayList<>();
    }

    public List<Postagem> getAll() {
        return database;
    }

    public Postagem add(Postagem newPostagem) {
        database.add(newPostagem);
        return database.get(database.size() - 1);
    }

    public Postagem getById(Long id) {
        return database.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Postagem update(Long id, Postagem updatedPostagem) {
        Postagem postagem = getById(id);
        if (postagem != null) {
            postagem.setTitulo(updatedPostagem.getTitulo());
            postagem.setConteudo(updatedPostagem.getConteudo());
        }
        return postagem;
    }

    public Postagem delete(Long id) {
        Postagem postagem = getById(id);
        if (postagem != null) {
            database.remove(postagem);
        }
        return postagem;
    }
}
