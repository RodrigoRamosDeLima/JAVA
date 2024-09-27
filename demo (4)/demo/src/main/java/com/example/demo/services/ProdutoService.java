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
    ProdutoRepository produtoRepository;

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public void createProduto(CreateProdutoDTO dto){

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(dto.getNome());

        produtoEntity = produtoRepository.save(produtoEntity);

        FornecedorEntity fornecedorEntity = new FornecedorEntity();
        fornecedorEntity.setNome(dto.getFornecedor().getNome());
        fornecedorEntity.setProduto(produtoEntity);

        fornecedorEntity = fornecedorRepository.save(fornecedorEntity);

        List<CategoriaEntity> categoriaEntity = new ArrayList<>();

        for(CreateCategoriaDTO categoriaDTO : dto.getCategorias()){
            CategoriaEntity categoriaEntity = new CategoriaEntity();
            categoriaEntity.setNome(categoriaDTO.getNome());
            categoriaEntity.setProduto(produtoEntity);
            categoriaEntity.add(categoriaEntity);

        }


        CategoriaRepository.saveALL(categoriaEntity);


    }

    public List<ShowProdutoDTO> getAllProdutos(){
        List<ProdutoEntity> produtoEntity = produtoRepository.findAll();

        return produtoEntity
                .stream()
                .map(produto -> {
                    ShowProdutoDTO showProdutoDTO = new ShowProdutoDTO();
                    ShowFornecedorDTO showFornecedorDTO = new ShowFornecedorDTO();
                    List<ShowCategoriaDTO> categoriaDTO = new ArrayList<>();

                    for(CategoriaEntity categoriaEntity : produto.getCategorias() ){
                        ShowCategoriaDTO categoriaDTO = new ShowCategoriaDTO();
                        categoriaDTO.setNome(categoriaEntity.getNome());
                        categoriaDTO.add(categoriaDTO);
                    }


                    fornecedorDTO.setNome(produto.getFornecedor().getNome());
                    produtoDTO.setId(produto.getId());
                    produtoDTO.setNome(produto.getNome());
                    produtoDTO.setFornecedor(fornecedorDTO);
                    produtoDTO.setCategorias(categoriaDTO);


                    return produtoDTO;

                }).toList();
    }
    
}
