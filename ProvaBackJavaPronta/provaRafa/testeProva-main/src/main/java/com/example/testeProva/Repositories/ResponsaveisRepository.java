package com.example.testeProva.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testeProva.Entities.ResponsaveisEntity;

@Repository
public interface ResponsaveisRepository extends JpaRepository<ResponsaveisEntity, Long> {

}
