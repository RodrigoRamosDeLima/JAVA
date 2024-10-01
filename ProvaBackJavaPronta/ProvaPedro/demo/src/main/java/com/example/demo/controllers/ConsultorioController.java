package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.req.CreateConsultorioDTO;
import com.example.demo.dtos.res.ShowConsultorioDTO;
import com.example.demo.services.ConsultorioService;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioController {

    @Autowired
    private ConsultorioService consultorioService;

    @PostMapping
    public ResponseEntity<?> createConsultorio(@RequestBody CreateConsultorioDTO dto) {
        // Chama o serviço para criar um novo consultório
        consultorioService.createConsultorio(dto);
        // Retorna o status 201 (Created)
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<ShowConsultorioDTO>> getAllConsultorios() {
        // Chama o serviço para buscar todos os consultórios
        List<ShowConsultorioDTO> consultorios = consultorioService.getConsultorios();
        // Retorna a lista de consultórios com o status 200 (OK)
        return ResponseEntity.ok(consultorios);
    }
}
