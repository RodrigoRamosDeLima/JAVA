package com.example.demo.dtos.req;

// Classe para o DTO de criação de endereços
public class CreateEnderecoDTO {
    private String rua; // Nome da rua
    private String numero; // Número da residência
    private String cidade; // Cidade

  


    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Getters e Setters
}
