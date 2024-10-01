package com.example.demo.dtos.req;

import java.util.List;

public class CreatePedidoDTO {

    private String produto;
    private Integer quantidade;
    private List<CreateClienteDTO> clientes;
    private CreateEnderecoDTO endereco; // Adicionando o campo para o endereço

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
    public List<CreateClienteDTO> getClientes() {
        return clientes;
    }
    public void setClientes(List<CreateClienteDTO> clientes) {
        this.clientes = clientes;
    }
    public CreateEnderecoDTO getEndereco() {
        return endereco; // Getter para o endereço
    }
    public void setEndereco(CreateEnderecoDTO endereco) {
        this.endereco = endereco; // Setter para o endereço
    }
}
