package com.example.demo.dtos.res;

import java.util.List;

// Classe para o DTO de resposta que exibe detalhes da clínica
public class ShowClinicaDTO {
    private Long id; // ID da clínica
    private String nome; // Nome da clínica
    private ShowEnderecoDTO endereco; // Endereço da clínica
    private List<ShowConsultaDTO> consultas; // Lista de consultas da clínica

  

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
    public ShowEnderecoDTO getEndereco() {
        return endereco;
    }
    public void setEndereco(ShowEnderecoDTO endereco) {
        this.endereco = endereco;
    }
    public List<ShowConsultaDTO> getConsultas() {
        return consultas;
    }
    public void setConsultas(List<ShowConsultaDTO> consultas) {
        this.consultas = consultas;
    }

    // Getters e Setters
}
