package br.edu.ifsp.bra.atividade1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ifsp.bra.atividade1.model.Postagem;
import br.edu.ifsp.bra.atividade1.service.PostagemService;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    PostagemService postagemService;

    @GetMapping
    public List<Postagem> getAllPostagens() {
        return postagemService.getAllPostagens();
    }

    @GetMapping("/{id}")
    public Postagem getPostagemById(@PathVariable Long id) {
        return postagemService.getPostagemById(id);
    }

    @PostMapping
    public Postagem addPostagem(@RequestBody Postagem newPostagem) {
        return postagemService.addPostagem(newPostagem);
    }

    @PutMapping("/{id}")
    public Postagem updatePostagem(@PathVariable Long id, @RequestBody Postagem updatePostagem) {
        return postagemService.updatePostagem(id, updatePostagem);
    }

    @DeleteMapping("/{id}")
    public Postagem deletePostagem(@PathVariable Long id) {
        return postagemService.deletePostagem(id);
    }
}
