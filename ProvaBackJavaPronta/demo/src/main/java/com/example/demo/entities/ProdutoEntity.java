package com.example.demo.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToOne(mappedBy = "produto") // Corrigido: referindo-se a 'produto' na FornecedorEntity
    private FornecedorEntity fornecedor;

    @OneToMany(mappedBy = "produto") // Corrigido: referindo-se a 'produto' na CategoriaEntity
    private List<CategoriaEntity> categorias;

    // Getters e Setters
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

    public FornecedorEntity getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorEntity fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<CategoriaEntity> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaEntity> categorias) {
        this.categorias = categorias;
    }
}
