package com.example.demo.dtos.res;

import java.time.LocalDate;

// Classe para o DTO de resposta que exibe detalhes das consultas
public class ShowConsultaDTO {
    private String nome; // Nome da consulta
    private LocalDate data; // Data da consulta
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    // Getters e Setters
}
