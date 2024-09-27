package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.CreateCategoriaDTO;
import com.example.demo.dtos.req.CreateProdutoDTO;
import com.example.demo.dtos.res.ShowCategoriaDTO;
import com.example.demo.dtos.res.ShowFornecedorDTO;
import com.example.demo.dtos.res.ShowProdutoDTO;
import com.example.demo.entities.CategoriaEntity;
import com.example.demo.entities.FornecedorEntity;
import com.example.demo.entities.ProdutoEntity;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.FornecedorRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void createProduto(CreateProdutoDTO dto) {
        // Cria um novo produto
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(dto.getNome());

        // Salva o produto
        produtoEntity = produtoRepository.save(produtoEntity);

        // Cria e associa o fornecedor
        FornecedorEntity fornecedorEntity = new FornecedorEntity();
        fornecedorEntity.setNome(dto.getFornecedor().getNome());
        fornecedorEntity.setTelefone(dto.getFornecedor().getTelefone());
        fornecedorEntity.setProduto(produtoEntity);

        // Salva o fornecedor
        fornecedorEntity = fornecedorRepository.save(fornecedorEntity);

        // Associa as categorias ao produto
        List<CategoriaEntity> categoriaEntities = new ArrayList<>();
        for (CreateCategoriaDTO categoriaDTO : dto.getCategorias()) {
            CategoriaEntity categoriaEntity = new CategoriaEntity();
            categoriaEntity.setNome(categoriaDTO.getNome());
            categoriaEntity.setProduto(produtoEntity); // Associando o produto à categoria
            categoriaEntities.add(categoriaEntity);
        }
        
        categoriaRepository.saveAll(categoriaEntities); // Salva a lista de categorias
        // Salva todas as categorias
    }

    public List<ShowProdutoDTO> getAllProdutos() {
        List<ProdutoEntity> produtoEntities = produtoRepository.findAll();

        // Converte entidades para DTOs
        return produtoEntities.stream()
                .map(produto -> {
                    ShowProdutoDTO showProdutoDTO = new ShowProdutoDTO();
                    ShowFornecedorDTO showFornecedorDTO = new ShowFornecedorDTO();
                    List<ShowCategoriaDTO> categoriaDTOs = new ArrayList<>();

                    // Converte as categorias do produto para ShowCategoriaDTO
                    for (CategoriaEntity categoriaEntity : produto.getCategorias()) {
                        ShowCategoriaDTO categoriaDTO = new ShowCategoriaDTO();
                        categoriaDTO.setNome(categoriaEntity.getNome());
                        categoriaDTOs.add(categoriaDTO);
                    }

                    // Converte o fornecedor do produto para ShowFornecedorDTO
                    showFornecedorDTO.setNome(produto.getFornecedor().getNome());
                    showFornecedorDTO.setTelefone(produto.getFornecedor().getTelefone());

                    // Preenche o ShowProdutoDTO
                    showProdutoDTO.setId(produto.getId());
                    showProdutoDTO.setNome(produto.getNome());
                    showProdutoDTO.setFornecedor(showFornecedorDTO);
                    showProdutoDTO.setCategorias(categoriaDTOs);

                    return showProdutoDTO;
                })
                .toList();
    }
}
