package br.edu.ifsp.bra.atividade1.model;

import java.time.LocalDateTime;

public class Postagem {
    private Long id;
    private String titulo;
    private String conteudo;
    private LocalDateTime dataCriacao;

    public Postagem() {
        this.dataCriacao = LocalDateTime.now();
    }

    public Postagem(Long id, String titulo, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) {
       this.id = id; 
    }

    public String getTitulo() { 
        return titulo; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }

    public String getConteudo() { 
        return conteudo; 
    }
    public void setConteudo(String conteudo) { 
        this.conteudo = conteudo; 
    }

    public LocalDateTime getDataCriacao() { 
        return dataCriacao; 
    }
    public void setDataCriacao(LocalDateTime dataCriacao) { 
        this.dataCriacao = dataCriacao; 
    }
}

