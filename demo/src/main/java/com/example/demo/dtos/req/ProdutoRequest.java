package com.example.demo.dtos.req;

import java.util.List;

public class ProdutoRequest {
    private String nome;
    private FornecedorRequest fornecedor;
    private List<CategoriaRequest> categorias;
    private int quantidade;

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public FornecedorRequest getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(FornecedorRequest fornecedor) {
        this.fornecedor = fornecedor;
    }
    public List<CategoriaRequest> getCategorias() {
        return categorias;
    }
    public void setCategorias(List<CategoriaRequest> categorias) {
        this.categorias = categorias;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
   
}



