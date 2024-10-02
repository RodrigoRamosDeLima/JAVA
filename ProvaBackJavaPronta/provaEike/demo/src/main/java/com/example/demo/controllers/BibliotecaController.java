package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.req.CreateBibliotecaDTO;
import com.example.demo.dtos.res.ShowBibliotecaDTO;
import com.example.demo.services.BibliotecaService;

@RestController
@RequestMapping("/bibliotecas")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    // Endpoint para criar uma nova biblioteca
    @PostMapping
    public ResponseEntity<?> createBiblioteca(@RequestBody CreateBibliotecaDTO dto) {
        // Chama o serviço para criar uma nova biblioteca
        bibliotecaService.createBiblioteca(dto);
        // Retorna o status 201 (Created)
        return ResponseEntity.status(201).build();
    }

    // Endpoint para buscar todas as bibliotecas
    @GetMapping
    public ResponseEntity<List<ShowBibliotecaDTO>> getAllBibliotecas() {
        // Chama o serviço para buscar todas as bibliotecas
        List<ShowBibliotecaDTO> bibliotecas = bibliotecaService.getBibliotecas();
        // Retorna a lista de bibliotecas com o status 200 (OK)
        return ResponseEntity.ok(bibliotecas);
    }
}
