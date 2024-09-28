package com.example.testeProva.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testeProva.Entities.ResponsaveisEntity;
import com.example.testeProva.Entities.TarefasEntity;
import com.example.testeProva.Entities.UsuariosEntity;
import com.example.testeProva.Repositories.ResponsaveisRepository;
import com.example.testeProva.Repositories.TarefasRepository;
import com.example.testeProva.Repositories.UsuariosRepository;
import com.example.testeProva.dtos.req.CreateTarefaDTO;
import com.example.testeProva.dtos.req.CreateUsuarioDTO;
import com.example.testeProva.dtos.res.ShowResponsavelDTO;
import com.example.testeProva.dtos.res.ShowTarefaDTO;
import com.example.testeProva.dtos.res.ShowUsuarioDTO;

@Service
public class TarefasService {

  @Autowired
  TarefasRepository tarefasRepository;

  @Autowired
  ResponsaveisRepository responsaveisRepository;

  @Autowired
  UsuariosRepository usuariosRepository;

  public void createTarefa(CreateTarefaDTO dto) {
    TarefasEntity tarefasEntity = new TarefasEntity();
    tarefasEntity.setTitulo(dto.getTitulo()); // Alterado de "setNome" para "setTitulo"

    tarefasEntity = tarefasRepository.save(tarefasEntity);

    ResponsaveisEntity responsaveisEntity = new ResponsaveisEntity();
    responsaveisEntity.setNome(dto.getResponsavel().getNome());
    responsaveisEntity.setEmail(dto.getResponsavel().getEmail());
    responsaveisEntity.setTarefa(tarefasEntity);

    responsaveisEntity = responsaveisRepository.save(responsaveisEntity);

    List<UsuariosEntity> usuariosEntity = new ArrayList<>();

    for (CreateUsuarioDTO usuarioDTO : dto.getUsuarios()) {
        UsuariosEntity usuarioEntity = new UsuariosEntity();
        usuarioEntity.setNome(usuarioDTO.getNome());
        usuarioEntity.setEmail(usuarioDTO.getEmail());
        usuarioEntity.setTarefa(tarefasEntity);

        usuariosEntity.add(usuarioEntity);
    }

    usuariosRepository.saveAll(usuariosEntity);
}


public List<ShowTarefaDTO> getAllTarefas() {
  List<TarefasEntity> tarefasEntity = tarefasRepository.findAll();

  return tarefasEntity.stream().map(tarefa -> {
      ShowTarefaDTO tarefaDTO = new ShowTarefaDTO();
      ShowResponsavelDTO responsavelDTO = new ShowResponsavelDTO();
      List<ShowUsuarioDTO> usuariosDTO = new ArrayList<>();

      // Verifica se a tarefa tem um responsável
      if (tarefa.getResponsavel() != null) {
          responsavelDTO.setNome(tarefa.getResponsavel().getNome());
          responsavelDTO.setEmail(tarefa.getResponsavel().getEmail());
          tarefaDTO.setResponsavel(responsavelDTO);
      } else {
          responsavelDTO.setNome("Sem Responsável");
          responsavelDTO.setEmail("");
          tarefaDTO.setResponsavel(responsavelDTO);
      }

      for (UsuariosEntity usuarioEntity : tarefa.getUsuarios()) {
          ShowUsuarioDTO usuarioDTO = new ShowUsuarioDTO();
          usuarioDTO.setNome(usuarioEntity.getNome());
          usuarioDTO.setEmail(usuarioEntity.getEmail());
          usuariosDTO.add(usuarioDTO);
      }

      tarefaDTO.setId(tarefa.getId());
      tarefaDTO.setNome(tarefa.getTitulo());
      tarefaDTO.setUsuarios(usuariosDTO);

      return tarefaDTO;
  }).toList();
}
}

// departamento = responsavel
// funcionario = tarefa
// projeto = usuario