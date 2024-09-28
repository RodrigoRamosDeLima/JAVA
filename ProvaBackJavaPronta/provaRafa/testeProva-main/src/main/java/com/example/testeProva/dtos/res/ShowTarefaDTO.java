package com.example.testeProva.dtos.res;

import java.util.List;

public class ShowTarefaDTO {

  private Long id;
  private String nome;
  private ShowResponsavelDTO responsavel;
  private List<ShowUsuarioDTO> usuarios;

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

  public ShowResponsavelDTO getResponsavel() {
    return responsavel;
  }

  public void setResponsavel(ShowResponsavelDTO responsavel) {
    this.responsavel = responsavel;
  }

  public List<ShowUsuarioDTO> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<ShowUsuarioDTO> usuarios) {
    this.usuarios = usuarios;
  }

}
