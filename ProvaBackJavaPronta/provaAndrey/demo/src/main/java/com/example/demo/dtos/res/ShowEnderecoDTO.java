package com.example.demo.dtos.res;

// Classe para o DTO de resposta que exibe detalhes do endereço
public class ShowEnderecoDTO {
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
