package com.example.demo.dtos.req;

import java.util.List;

public class CreateProdutoDTO {

    private String nome;
    private CreateFornecedorDTO fornecedor;
    private List<CreateCategoriaDTO> categorias;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public CreateFornecedorDTO getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(CreateFornecedorDTO fornecedor) {
        this.fornecedor = fornecedor;
    }
    public List<CreateCategoriaDTO> getCategorias() {
        return categorias;
    }
    public void setCategorias(List<CreateCategoriaDTO> categorias) {
        this.categorias = categorias;
    }
    
}
