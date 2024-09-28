package com.example.testeProva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testeProva.dtos.req.CreateTarefaDTO;
import com.example.testeProva.dtos.res.ShowTarefaDTO;
import com.example.testeProva.services.TarefasService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

  @Autowired
  TarefasService tarefaService;

  @PostMapping
  public ResponseEntity<?> createTarefa(@RequestBody CreateTarefaDTO dto) {
      tarefaService.createTarefa(dto);
      return ResponseEntity.status(201).build();
  }
  
  @GetMapping
  public ResponseEntity<?> getAllTarefas() {
      List<ShowTarefaDTO> tarefas = tarefaService.getAllTarefas();
      return ResponseEntity.status(200).body(tarefas);
  }
  

}
