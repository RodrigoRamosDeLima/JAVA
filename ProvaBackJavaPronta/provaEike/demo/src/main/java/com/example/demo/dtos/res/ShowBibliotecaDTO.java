package com.example.demo.dtos.res;

import java.util.List;

public class ShowBibliotecaDTO {

    private Long id;
    private String nome;
    private List<ShowLivroDTO> livros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ShowLivroDTO> getLivros() {
        return livros;
    }

    public void setLivros(List<ShowLivroDTO> livros) {
        this.livros = livros;
    }
}
