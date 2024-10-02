package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.LivroEntity;

public interface LivroRepository  extends JpaRepository<LivroEntity, Long>{
    
}
