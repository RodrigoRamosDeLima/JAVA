package com.example.demo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.req.ProdutoRequest;
import com.example.demo.dtos.res.ProdutoResponse;
import com.example.demo.services.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> createProduto(@RequestBody ProdutoRequest request) {
        return ResponseEntity.ok(estoqueService.createProduto(request));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> getAllProdutos() {
        return ResponseEntity.ok(estoqueService.getAllProdutos());
    }
}