package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.req.CreateClinicaDTO;
import com.example.demo.dtos.res.ShowClinicaDTO;
import com.example.demo.services.ClinicaService;

// Definindo a classe ClinicaController, que gerencia as requisições relacionadas às clínicas
@RestController
@RequestMapping("/clinicas") // Mapeia a URL base para "/clinicas"
public class ClinicaController {

    // Injetando o serviço ClinicaService
    @Autowired
    private ClinicaService clinicaService;

    // Método para criar uma nova clínica
    @PostMapping
    public ResponseEntity<?> createClinica(@RequestBody CreateClinicaDTO dto) {
        clinicaService.createClinica(dto); // Chama o serviço para criar a clínica
        return ResponseEntity.status(201).build(); // Retorna um status 201 (Criado)
    }

    // Método para listar todas as clínicas
    @GetMapping
    public ResponseEntity<List<ShowClinicaDTO>> getAllClinicas() {
        List<ShowClinicaDTO> clinicas = clinicaService.getClinicas(); // Obtém a lista de clínicas
        return ResponseEntity.ok(clinicas); // Retorna a lista com status 200 (OK)
    }
}


