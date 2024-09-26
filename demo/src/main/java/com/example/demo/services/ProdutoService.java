// package com.example.demo.services;

// import com.example.demo.dtos.req.ProdutoRequest;
// import com.example.demo.entities.Categoria;
// import com.example.demo.entities.Fornecedor;
// import com.example.demo.entities.Produto;
// import com.example.demo.repositories.CategoriaRepository;
// import com.example.demo.repositories.FornecedorRepository;
// import com.example.demo.repositories.ProdutoRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class ProdutoService {
//     @Autowired
//     private ProdutoRepository produtoRepository;

//     @Autowired
//     private FornecedorRepository fornecedorRepository;

//     @Autowired
//     private CategoriaRepository categoriaRepository;

//     public Produto createProduto(ProdutoRequest request) {
//         Produto produto = new Produto();
//         produto.setNome(request.getNome());
//         produto.setQuantidade(request.getQuantidade());

//         // Associar Fornecedor
//         if (request.getFornecedorId() != null) {
//             Fornecedor fornecedor = fornecedorRepository.findById(request.getFornecedorId()).orElse(null);
//             produto.setFornecedor(fornecedor);
//         }

//         // Associar Categorias
//         if (request.getCategoriasIds() != null) {
//             List<Categoria> categorias = new ArrayList<>();
//             for (Long id : request.getCategoriasIds()) {
//                 Categoria categoria = categoriaRepository.findById(id).orElse(null);
//                 if (categoria != null) {
//                     categorias.add(categoria);
//                 }
//             }
//             produto.setCategorias(categorias);
//         }

//         return produtoRepository.save(produto);
//     }

//     public List<Produto> getAllProdutos() {
//         return produtoRepository.findAll();
//     }

//     public Produto getProdutoById(Long id) {
//         return produtoRepository.findById(id).orElse(null);
//     }

//     public Produto updateProduto(Long id, ProdutoRequest request) {
//         Produto produto = getProdutoById(id);
//         if (produto != null) {
//             produto.setNome(request.getNome());
//             produto.setQuantidade(request.getQuantidade());

//             // Associar Fornecedor
//             if (request.getFornecedorId() != null) {
//                 Fornecedor fornecedor = fornecedorRepository.findById(request.getFornecedorId()).orElse(null);
//                 produto.setFornecedor(fornecedor);
//             }

//             // Associar Categorias
//             if (request.getCategoriasIds() != null) {
//                 List<Categoria> categorias = new ArrayList<>();
//                 for (Long catId : request.getCategoriasIds()) {
//                     Categoria categoria = categoriaRepository.findById(catId).orElse(null);
//                     if (categoria != null) {
//                         categorias.add(categoria);
//                     }
//                 }
//                 produto.setCategorias(categorias);
//             }

//             return produtoRepository.save(produto);
//         }
//         return null;
//     }

//     public void deleteProduto(Long id) {
//         produtoRepository.deleteById(id);
//     }
// }


