package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.EnderecoEntity;


// Interface do repositório para a entidade Endereco
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
    // O Spring Data JPA fornece métodos CRUD automaticamente
}
