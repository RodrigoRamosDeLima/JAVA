package com.example.demo.dtos.res;

import java.util.List;

public class ProdutoResponse {
    private Long id;
    private String nome;
    private FornecedorResponse fornecedor;
    private List<CategoriaResponse> categorias;
    private int quantidade;
   
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
    public FornecedorResponse getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(FornecedorResponse fornecedor) {
        this.fornecedor = fornecedor;
    }
    public List<CategoriaResponse> getCategorias() {
        return categorias;
    }
    public void setCategorias(List<CategoriaResponse> categorias) {
        this.categorias = categorias;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}