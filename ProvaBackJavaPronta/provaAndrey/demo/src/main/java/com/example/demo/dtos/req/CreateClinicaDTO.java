package com.example.demo.dtos.req;

import java.util.List;

// Classe para o DTO de criação de clínicas
public class CreateClinicaDTO {
    private String nome; // Nome da clínica
    private CreateEnderecoDTO endereco; // Endereço da clínica
    private List<CreateConsultaDTO> consultas; // Lista de consultas associadas

   


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public CreateEnderecoDTO getEndereco() {
        return endereco;
    }
    public void setEndereco(CreateEnderecoDTO endereco) {
        this.endereco = endereco;
    }
    public List<CreateConsultaDTO> getConsultas() {
        return consultas;
    }
    public void setConsultas(List<CreateConsultaDTO> consultas) {
        this.consultas = consultas;
    }

    // Getters e Setters
}
