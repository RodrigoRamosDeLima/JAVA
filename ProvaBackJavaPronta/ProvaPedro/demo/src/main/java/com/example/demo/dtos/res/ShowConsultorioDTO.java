package com.example.demo.dtos.res;

import java.util.List;

public class ShowConsultorioDTO {

    private Long id;
    private String nome;
    private ShowEnderecoDTO endereco;
    private List<ShowPacienteDTO> pacientes;
    
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
    public List<ShowPacienteDTO> getPacientes() {
        return pacientes;
    }
    public void setPacientes(List<ShowPacienteDTO> pacientes) {
        this.pacientes = pacientes;
    }
    
}
