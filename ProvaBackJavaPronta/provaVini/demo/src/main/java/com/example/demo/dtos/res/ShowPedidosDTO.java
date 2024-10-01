package com.example.demo.dtos.res;

import java.util.List;

public class ShowPedidosDTO {
    private String id;
    private String produto;
    private Integer quantidade;
    private List<ShowClienteDTO> clientes;
    private ShowEnderecoDTO endereco; // Add this line

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public List<ShowClienteDTO> getClientes() {
        return clientes;
    }
    public void setClientes(List<ShowClienteDTO> clientes) {
        this.clientes = clientes;
    }
    public ShowEnderecoDTO getEndereco() { // Add this getter
        return endereco;
    }
    public void setEndereco(ShowEnderecoDTO endereco) { // Update the parameter type
        this.endereco = endereco;
    }
}
