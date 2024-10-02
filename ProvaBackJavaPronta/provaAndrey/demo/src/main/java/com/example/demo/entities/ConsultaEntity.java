package com.example.demo.entities;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// Classe da entidade Consulta, que representa a tabela "consulta"
@Entity(name = "consultas")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID da consulta

    private String nome; // Nome da consulta
    private LocalDate data; // Data da consulta

    @ManyToOne
    @JoinColumn(name = "clinica_id") // Mapeia o relacionamento com a entidade Clinica
    private ClinicaEntity clinica; // Clínica associada à consulta

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ClinicaEntity getClinica() {
        return clinica;
    }

    public void setClinica(ClinicaEntity clinica) {
        this.clinica = clinica;
    }

  
}
