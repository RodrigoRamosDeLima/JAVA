package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BibliotecaController {

    @GetMapping("/bibliotecas")
    public String findBiblioteca() {
        return "Teste";
    }

    @PostMapping("/livros")
    public String createBiblioteca(){
        return "Criado";
    }

    @DeleteMapping("/livros/{id}")
    public String deleteBiblioteca(@PathVariable("id") int idLivro){
        return "Deletado";
    }

    @PatchMapping("/livros/{id}")
    public String updateBibliotecaParcialmente(@PathVariable("id") int idLivro){
        return "Atualizado parcialmente";
    }

    @PutMapping("/livros/{id}")
    public String updateBiblioteca(@PathVariable("id") int idLivro){
        return "Atualizado ";
    }
    
}
