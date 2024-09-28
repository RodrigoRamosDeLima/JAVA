package com.example.testeProva.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tarefas")
public class TarefasEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "titulo")
  private String titulo;

  @OneToOne(mappedBy = "tarefa")
  private ResponsaveisEntity responsavel;

  @OneToMany(mappedBy = "tarefa")
  private List<UsuariosEntity> usuarios;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public ResponsaveisEntity getResponsavel() {
    return responsavel;
  }

  public void setResponsavel(ResponsaveisEntity responsavel) {
    this.responsavel = responsavel;
  }

  public List<UsuariosEntity> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<UsuariosEntity> usuarios) {
    this.usuarios = usuarios;
  }

 

}
