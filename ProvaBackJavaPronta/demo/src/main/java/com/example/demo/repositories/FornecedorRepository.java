package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.FornecedorEntity;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {
}
