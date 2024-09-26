package com.example.demo.services;

import com.example.demo.dtos.req.CategoriaRequest;
import com.example.demo.entities.Categoria;
import com.example.demo.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria createCategoria(CategoriaRequest request) {
        Categoria categoria = new Categoria();
        categoria.setNome(request.getNome());
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria updateCategoria(Long id, CategoriaRequest request) {
        Categoria categoria = getCategoriaById(id);
        if (categoria != null) {
            categoria.setNome(request.getNome());
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}

