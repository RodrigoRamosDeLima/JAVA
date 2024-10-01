package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.CreateConsultorioDTO;
import com.example.demo.dtos.req.CreatePacienteDTO;
import com.example.demo.dtos.res.ShowConsultorioDTO;
import com.example.demo.dtos.res.ShowEnderecoDTO;
import com.example.demo.dtos.res.ShowPacienteDTO;

import com.example.demo.entities.ConsultorioEntity;
import com.example.demo.entities.EnderecoEntity;
import com.example.demo.entities.PacienteEntity;
import com.example.demo.repositories.ConsultorioRepository;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.repositories.PacienteRepository;

@Service
public class ConsultorioService {

    @Autowired
    private ConsultorioRepository consultorioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void createConsultorio(CreateConsultorioDTO dto) {

        // Cria e salva o consultório
        ConsultorioEntity consultorioEntity = new ConsultorioEntity();
        consultorioEntity.setNome(dto.getNome());
        consultorioEntity = consultorioRepository.save(consultorioEntity);

        // Cria e salva o endereço do consultório
        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setRua(dto.getEndereco().getRua());
        enderecoEntity.setNumero(dto.getEndereco().getNumero());
        enderecoEntity.setCidade(dto.getEndereco().getCidade());
        enderecoEntity.setConsultorio(consultorioEntity);
        enderecoRepository.save(enderecoEntity);

        // Cria e salva os pacientes
        List<PacienteEntity> pacientesEntity = new ArrayList<>();
        for (CreatePacienteDTO pacienteDTO : dto.getPacientes()) {
            PacienteEntity pacienteEntity = new PacienteEntity();
            pacienteEntity.setNome(pacienteDTO.getNome());
            pacienteEntity.setIdade(pacienteDTO.getIdade());
            pacienteEntity.setConsultorio(consultorioEntity); 
            pacientesEntity.add(pacienteEntity);
        }
        pacienteRepository.saveAll(pacientesEntity);
    }

    public List<ShowConsultorioDTO> getConsultorios() {
        List<ConsultorioEntity> consultoriosEntity = consultorioRepository.findAll();

        return consultoriosEntity.stream().map(consultorio -> {
            ShowConsultorioDTO consultorioDTO = new ShowConsultorioDTO();
            ShowEnderecoDTO enderecoDTO = new ShowEnderecoDTO();
            List<ShowPacienteDTO> pacientesDTO = new ArrayList<>();

            // Mapeia pacientes
            for (PacienteEntity pacienteEntity : consultorio.getPacientes()) {
                ShowPacienteDTO pacienteDTO = new ShowPacienteDTO();
                pacienteDTO.setNome(pacienteEntity.getNome());
                pacienteDTO.setIdade(pacienteEntity.getIdade());
                pacientesDTO.add(pacienteDTO);
            }

            // Mapeia endereço
            enderecoDTO.setRua(consultorio.getEndereco().getRua());
            enderecoDTO.setNumero(consultorio.getEndereco().getNumero());
            enderecoDTO.setCidade(consultorio.getEndereco().getCidade());

            // Mapeia consultório
            consultorioDTO.setId(consultorio.getId());
            consultorioDTO.setNome(consultorio.getNome());
            consultorioDTO.setEndereco(enderecoDTO);
            consultorioDTO.setPacientes(pacientesDTO);

            return consultorioDTO;
        }).toList();
    }
}
