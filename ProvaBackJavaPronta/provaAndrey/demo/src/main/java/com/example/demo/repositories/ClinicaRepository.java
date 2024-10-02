package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.ClinicaEntity;

// Interface do repositório para a entidade Clinica
public interface ClinicaRepository extends JpaRepository<ClinicaEntity, Long> {
    // O Spring Data JPA fornece métodos CRUD automaticamente
}
