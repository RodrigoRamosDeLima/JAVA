package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.ConsultaEntity;

// Interface do repositório para a entidade Consulta
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {
    // O Spring Data JPA fornece métodos CRUD automaticamente
}

