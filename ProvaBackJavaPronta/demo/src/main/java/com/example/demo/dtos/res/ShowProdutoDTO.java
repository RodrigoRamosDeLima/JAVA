package com.example.demo.dtos.res;

import java.util.List;


public class ShowProdutoDTO {
    private Long id;
    private String nome;
     private ShowFornecedorDTO fornecedor;
    private List<ShowCategoriaDTO> categorias;
    
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
    public ShowFornecedorDTO getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(ShowFornecedorDTO fornecedor) {
        this.fornecedor = fornecedor;
    }
    public List<ShowCategoriaDTO> getCategorias() {
        return categorias;
    }
    public void setCategorias(List<ShowCategoriaDTO> categorias) {
        this.categorias = categorias;
    }
    
}
