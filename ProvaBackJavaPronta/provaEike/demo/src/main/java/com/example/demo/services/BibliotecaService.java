package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.CreateBibliotecaDTO;
import com.example.demo.dtos.req.CreateLivroDTO;
import com.example.demo.dtos.res.ShowBibliotecaDTO;
import com.example.demo.dtos.res.ShowLivroDTO;
import com.example.demo.dtos.res.ShowAutorDTO;
import com.example.demo.entities.BibliotecaEntity;
import com.example.demo.entities.LivroEntity;
import com.example.demo.entities.AutorEntity;
import com.example.demo.repositories.BibliotecaRepository;
import com.example.demo.repositories.LivroRepository;
import com.example.demo.repositories.AutorRepository;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    // Método para criar uma nova biblioteca com seus livros e autores
    public void createBiblioteca(CreateBibliotecaDTO dto) {

        // Cria e salva a biblioteca
        BibliotecaEntity bibliotecaEntity = new BibliotecaEntity();
        bibliotecaEntity.setNome(dto.getNome());
        bibliotecaEntity = bibliotecaRepository.save(bibliotecaEntity);

        // Cria e salva os livros e autores
        List<LivroEntity> livrosEntity = new ArrayList<>();
        for (CreateLivroDTO livroDTO : dto.getLivros()) {
            LivroEntity livroEntity = new LivroEntity();
            livroEntity.setTitulo(livroDTO.getTitulo());
            livroEntity.setBiblioteca(bibliotecaEntity);

            // Salva o livro antes de associar o autor
            livroEntity = livroRepository.save(livroEntity);

            // Cria o autor e associa ao livro
            AutorEntity autorEntity = new AutorEntity();
            autorEntity.setNome(livroDTO.getAutor().getNome());
            autorEntity.setNacionalidade(livroDTO.getAutor().getNacionalidade());
            autorEntity.setLivro(livroEntity); // Relacionamento 1:1

            // Agora salva o autor
            autorRepository.save(autorEntity);

            // Adiciona o livro à lista de livros da biblioteca
            livrosEntity.add(livroEntity);
        }

        // Atualiza a lista de livros na biblioteca
        bibliotecaEntity.setLivros(livrosEntity);
    }

    // Método para listar todas as bibliotecas
    public List<ShowBibliotecaDTO> getBibliotecas() {
        List<BibliotecaEntity> bibliotecasEntity = bibliotecaRepository.findAll();

        return bibliotecasEntity.stream().map(biblioteca -> {
            ShowBibliotecaDTO bibliotecaDTO = new ShowBibliotecaDTO();
            List<ShowLivroDTO> livrosDTO = new ArrayList<>();

            // Mapeia livros e autores
            for (LivroEntity livroEntity : biblioteca.getLivros()) {
                ShowLivroDTO livroDTO = new ShowLivroDTO();
                livroDTO.setId(livroEntity.getId());
                livroDTO.setTitulo(livroEntity.getTitulo());

                // Mapeia autor
                ShowAutorDTO autorDTO = new ShowAutorDTO();
                autorDTO.setNome(livroEntity.getAutor().getNome());
                autorDTO.setNacionalidade(livroEntity.getAutor().getNacionalidade());
                
                livroDTO.setAutor(autorDTO);
                livrosDTO.add(livroDTO);
            }

            // Mapeia biblioteca
            bibliotecaDTO.setId(biblioteca.getId());
            bibliotecaDTO.setNome(biblioteca.getNome());
            bibliotecaDTO.setLivros(livrosDTO);

            return bibliotecaDTO;
        }).toList();
    }
}
