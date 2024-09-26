package com.example.demo.controllers;

import com.example.demo.dtos.req.FornecedorRequest;
import com.example.demo.entities.Fornecedor;
import com.example.demo.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody FornecedorRequest request) {
        Fornecedor fornecedor = fornecedorService.createFornecedor(request);
        return new ResponseEntity<>(fornecedor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAllFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.getAllFornecedores();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.getFornecedorById(id);
        return fornecedor != null ? new ResponseEntity<>(fornecedor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody FornecedorRequest request) {
        Fornecedor fornecedor = fornecedorService.updateFornecedor(id, request);
        return fornecedor != null ? new ResponseEntity<>(fornecedor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable Long id) {
        fornecedorService.deleteFornecedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
