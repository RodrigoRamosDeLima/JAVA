package com.example.demo.dtos.req;

import java.util.List;

public class CreateBibliotecaDTO {

    private String nome;
    private List<CreateLivroDTO> livros;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CreateLivroDTO> getLivros() {
        return livros;
    }

    public void setLivros(List<CreateLivroDTO> livros) {
        this.livros = livros;
    }
}
