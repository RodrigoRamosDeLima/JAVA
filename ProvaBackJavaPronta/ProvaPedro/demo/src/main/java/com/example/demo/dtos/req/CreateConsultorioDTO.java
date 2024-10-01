package com.example.demo.dtos.req;

import java.util.List;

public class CreateConsultorioDTO {

    private String nome;
    private CreateEnderecoDTO endereco;
    private List<CreatePacienteDTO> pacientes;

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
    public List<CreatePacienteDTO> getPacientes() {
        return pacientes;
    }
    public void setPacientes(List<CreatePacienteDTO> pacientes) {
        this.pacientes = pacientes;
    };
    
}
