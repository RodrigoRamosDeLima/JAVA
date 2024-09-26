// package com.example.demo.controllers;

// import com.example.demo.dtos.req.ProdutoRequest;
// import com.example.demo.entities.Produto;
// import com.example.demo.services.ProdutoService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/produtos")
// public class ProdutoController {
//     @Autowired
//     private ProdutoService produtoService;

//     @PostMapping
//     public ResponseEntity<Produto> createProduto(@RequestBody ProdutoRequest request) {
//         Produto produto = produtoService.createProduto(request);
//         return new ResponseEntity<>(produto, HttpStatus.CREATED);
//     }

//     @GetMapping
//     public ResponseEntity<List<Produto>> getAllProdutos() {
//         List<Produto> produtos = produtoService.getAllProdutos();
//         return new ResponseEntity<>(produtos, HttpStatus.OK);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
//         Produto produto = produtoService.getProdutoById(id);
//         return produto != null ? new ResponseEntity<>(produto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody ProdutoRequest request) {
//         Produto produto = produtoService.updateProduto(id, request);
//         return produto != null ? new ResponseEntity<>(produto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
//         produtoService.deleteProduto(id);
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     }
// }
