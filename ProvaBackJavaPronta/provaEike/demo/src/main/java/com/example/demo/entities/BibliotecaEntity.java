package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "bibliotecas")
public class BibliotecaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "biblioteca")
    private List<LivroEntity> livros;

   
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

    public List<LivroEntity> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroEntity> livros) {
        this.livros = livros;
    }
}
