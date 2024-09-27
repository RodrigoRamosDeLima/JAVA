package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.req.CreateProdutoDTO;
import com.example.demo.dtos.res.ShowProdutoDTO;
import com.example.demo.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> createProduto(@RequestBody CreateProdutoDTO dto){

        produtoService.createProduto(dto);
            
        return ResponseEntity.status(201).build();

    }

    @GetMapping
    public ResponseEntity<?>getAllProdutos(){

        List<ShowProdutoDTO> produtos = produtoService.getAllProdutos();

        return ResponseEntity.status(200).body(produtos);
    }
    
}
