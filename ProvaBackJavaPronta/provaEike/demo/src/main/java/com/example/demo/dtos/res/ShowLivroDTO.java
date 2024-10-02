package com.example.demo.dtos.res;

public class ShowLivroDTO {

    private Long id;
    private String titulo;
    private ShowAutorDTO autor;

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

    public ShowAutorDTO getAutor() {
        return autor;
    }

    public void setAutor(ShowAutorDTO autor) {
        this.autor = autor;
    }
}
