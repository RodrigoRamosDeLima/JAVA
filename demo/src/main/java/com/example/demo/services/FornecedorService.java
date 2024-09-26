package com.example.demo.services;

import com.example.demo.dtos.req.FornecedorRequest;
import com.example.demo.entities.Fornecedor;
import com.example.demo.repositories.FornecedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor createFornecedor(FornecedorRequest request) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(request.getNome());
        fornecedor.setTelefone(request.getTelefone());
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor getFornecedorById(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public Fornecedor updateFornecedor(Long id, FornecedorRequest request) {
        Fornecedor fornecedor = getFornecedorById(id);
        if (fornecedor != null) {
            fornecedor.setNome(request.getNome());
            fornecedor.setTelefone(request.getTelefone());
            return fornecedorRepository.save(fornecedor);
        }
        return null;
    }

    public void deleteFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}

