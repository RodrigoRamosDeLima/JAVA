package com.example.testeProva.dtos.req;

import java.util.List;

public class CreateTarefaDTO {

  private String titulo;
  private CreateResponsavelDTO responsavel;
  private List<CreateUsuarioDTO> usuarios;
  
  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  public CreateResponsavelDTO getResponsavel() {
    return responsavel;
  }
  public void setResponsavel(CreateResponsavelDTO responsavel) {
    this.responsavel = responsavel;
  }
  public List<CreateUsuarioDTO> getUsuarios() {
    return usuarios;
  }
  public void setUsuarios(List<CreateUsuarioDTO> usuarios) {
    this.usuarios = usuarios;
  }

 
}
