package br.edu.ifsp.bra.atividade1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifsp.bra.atividade1.model.Postagem;
import br.edu.ifsp.bra.atividade1.repository.PostagemRepository;

@Component
public class PostagemService {

    @Autowired
    PostagemRepository postagemRepository;

    public List<Postagem> getAllPostagens() {
        return postagemRepository.getAll();
    }

    public Postagem getPostagemById(Long id) {
        return postagemRepository.getById(id);
    }

    public Postagem addPostagem(Postagem newPostagem) {
        return postagemRepository.add(newPostagem);
    }

    public Postagem updatePostagem(Long id, Postagem updatePostagem) {
        return postagemRepository.update(id, updatePostagem);
    }

    public Postagem deletePostagem(Long id) {
        return postagemRepository.delete(id);
    }

    public List<Postagem> listarTodas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodas'");
    }

    public Object buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    public Postagem salvar(Postagem postagem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    public Object atualizar(Long id, Postagem postagem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }
}
