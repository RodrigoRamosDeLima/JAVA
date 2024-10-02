package com.example.demo.dtos.req;

public class CreateLivroDTO {

    private String titulo;
    private CreateAutorDTO autor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public CreateAutorDTO getAutor() {
        return autor;
    }

    public void setAutor(CreateAutorDTO autor) {
        this.autor = autor;
    }
}
