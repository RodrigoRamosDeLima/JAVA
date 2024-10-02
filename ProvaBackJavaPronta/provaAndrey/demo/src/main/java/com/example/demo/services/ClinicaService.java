package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.CreateClinicaDTO;
import com.example.demo.dtos.req.CreateConsultaDTO;
import com.example.demo.dtos.res.ShowClinicaDTO;
import com.example.demo.dtos.res.ShowEnderecoDTO;
import com.example.demo.dtos.res.ShowConsultaDTO;
import com.example.demo.entities.ClinicaEntity;
import com.example.demo.entities.ConsultaEntity;
import com.example.demo.entities.EnderecoEntity;
import com.example.demo.repositories.ClinicaRepository;
import com.example.demo.repositories.ConsultaRepository;
import com.example.demo.repositories.EnderecoRepository;
// Classe do serviço que contém a lógica de negócio para a clínica
@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository; // Repositório de clínicas

    @Autowired
    private ConsultaRepository consultaRepository; // Repositório de consultas

    @Autowired
    private EnderecoRepository enderecoRepository; // Repositório de endereços

    // Método para criar nova clínica com endereço e consultas
    public void createClinica(CreateClinicaDTO dto) {
        // Criar e salvar o endereço
        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setRua(dto.getEndereco().getRua()); // Define a rua do endereço
        enderecoEntity.setNumero(dto.getEndereco().getNumero()); // Define o número do endereço
        enderecoEntity.setCidade(dto.getEndereco().getCidade()); // Define a cidade do endereço
        enderecoEntity = enderecoRepository.save(enderecoEntity); // Salva o endereço no banco

        // Criar a clínica
        ClinicaEntity clinicaEntity = new ClinicaEntity();
        clinicaEntity.setNome(dto.getNome()); // Define o nome da clínica
        clinicaEntity.setEndereco(enderecoEntity); // Associa o endereço à clínica

        // Criar as consultas
        List<ConsultaEntity> consultasEntity = new ArrayList<>(); // Lista para armazenar consultas
        for (CreateConsultaDTO consultaDTO : dto.getConsultas()) { // Itera sobre as consultas do DTO
            ConsultaEntity consultaEntity = new ConsultaEntity();
            consultaEntity.setNome(consultaDTO.getNome()); // Define o nome da consulta
            consultaEntity.setData(consultaDTO.getData()); // Define a data da consulta
            consultaEntity.setClinica(clinicaEntity); // Associa a consulta à clínica

            consultasEntity.add(consultaEntity); // Adiciona a consulta à lista
        }
        clinicaEntity.setConsultas(consultasEntity); // Associa a lista de consultas à clínica

        // Salva a clínica (as consultas serão salvas em cascata)
        clinicaRepository.save(clinicaEntity);
    }

    // Método para listar todas as clínicas
    public List<ShowClinicaDTO> getClinicas() {
        List<ClinicaEntity> clinicasEntity = clinicaRepository.findAll(); // Obtém todas as clínicas do repositório

        return clinicasEntity.stream().map(clinica -> {
            ShowClinicaDTO clinicaDTO = new ShowClinicaDTO(); // Cria um DTO de resposta
            clinicaDTO.setId(clinica.getId()); // Define o ID da clínica
            clinicaDTO.setNome(clinica.getNome()); // Define o nome da clínica

            // Mapeia o endereço
            ShowEnderecoDTO enderecoDTO = new ShowEnderecoDTO();
            enderecoDTO.setRua(clinica.getEndereco().getRua()); // Define a rua do endereço
            enderecoDTO.setNumero(clinica.getEndereco().getNumero()); // Define o número do endereço
            enderecoDTO.setCidade(clinica.getEndereco().getCidade()); // Define a cidade do endereço
            clinicaDTO.setEndereco(enderecoDTO); // Associa o endereço ao DTO da clínica

            // Mapeia as consultas
            List<ShowConsultaDTO> consultasDTO = new ArrayList<>();
            for (ConsultaEntity consultaEntity : clinica.getConsultas()) { // Itera sobre as consultas da clínica
                ShowConsultaDTO consultaDTO = new ShowConsultaDTO();
                consultaDTO.setNome(consultaEntity.getNome()); // Define o nome da consulta
                consultaDTO.setData(consultaEntity.getData()); // Define a data da consulta
                consultasDTO.add(consultaDTO); // Adiciona a consulta ao DTO
            }
            clinicaDTO.setConsultas(consultasDTO); // Associa a lista de consultas ao DTO da clínica

            return clinicaDTO; // Retorna o DTO da clínica
        }).toList(); // Converte para uma lista
    }
}
