package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.CategoriaRequest;
import com.example.demo.dtos.req.FornecedorRequest;
import com.example.demo.dtos.req.ProdutoRequest;
import com.example.demo.dtos.res.CategoriaResponse;
import com.example.demo.dtos.res.FornecedorResponse;
import com.example.demo.dtos.res.ProdutoResponse;
import com.example.demo.entities.Categoria;
import com.example.demo.entities.Fornecedor;
import com.example.demo.entities.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.FornecedorRepository;
import com.example.demo.repositories.ProdutoRepository;

@Service
public class EstoqueService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public ProdutoResponse createProduto(ProdutoRequest request) {
        Produto produto = new Produto();
        produto.setNome(request.getNome());
        produto.setQuantidade(request.getQuantidade());
    
        
        Fornecedor fornecedor = configureFornecedor(request.getFornecedor());
        produto.setFornecedor(fornecedor);
    
        
        List<Categoria> categorias = configureCategorias(request.getCategorias(), produto);
        produto.setCategorias(categorias);
    
      
        Produto savedProduto = produtoRepository.save(produto);
    
        return convertToResponse(savedProduto);
    }
    
    private Fornecedor configureFornecedor(FornecedorRequest fornecedorRequest) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(fornecedorRequest.getNome());
        fornecedor.setTelefone(fornecedorRequest.getTelefone());
        return fornecedorRepository.save(fornecedor); 
    }
    
    private List<Categoria> configureCategorias(List<CategoriaRequest> categoriaRequests, Produto produto) {
        return categoriaRequests.stream()
                .map(categoriaRequest -> {
                    Categoria categoria = new Categoria();
                    categoria.setNome(categoriaRequest.getNome());
                    categoria.setProduto(produto); 
                    return categoriaRepository.save(categoria); 
                })
                .collect(Collectors.toList());
    }
    
    public List<ProdutoResponse> getAllProdutos() {
        return produtoRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    
    private ProdutoResponse convertToResponse(Produto produto) {
        ProdutoResponse response = new ProdutoResponse();
        response.setId(produto.getId());
        response.setNome(produto.getNome());
        response.setQuantidade(produto.getQuantidade());
    
        Fornecedor fornecedor = produto.getFornecedor();
        response.setFornecedor(new FornecedorResponse(fornecedor.getId(), fornecedor.getNome(), fornecedor.getTelefone()));
    
       
        List<CategoriaResponse> categoriaResponses = produto.getCategorias().stream()
                .map(categoria -> new CategoriaResponse(categoria.getId(), categoria.getNome()))
                .collect(Collectors.toList());
        response.setCategorias(categoriaResponses);
    
        return response;
    }
    }
    
