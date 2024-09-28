package com.example.testeProva.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testeProva.Entities.TarefasEntity;

@Repository
public interface TarefasRepository extends JpaRepository<TarefasEntity, Long> {

}
