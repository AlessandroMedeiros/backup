package com.all.locadora.controller;

import com.all.locadora.model.FilmeModel;
import com.all.locadora.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<FilmeModel> listarFilmes() {
        List<FilmeModel> listaFilmes = filmeRepository.findAll();

        //listaFilmes.stream().filter(filme -> filme.getQuantidade()>0).collect(Collectors.toList());

        listaFilmesDisponiveis(listaFilmes);

        return listaFilmes;
    }

    private List<FilmeModel> listaFilmesDisponiveis(List<FilmeModel> listaFilmes) {
        for (int i = 0; i < listaFilmes.size(); i++) {
            if (listaFilmes.get(i).getQuantidade() == 0) {
                listaFilmes.remove(i);
            }
        }
        return listaFilmes;
    }

    @GetMapping("/{titulo}/pesquisar")
    public Optional<FilmeModel> listarFilmeTitulo(@PathVariable String titulo) {
        return filmeRepository.findByTitulo(titulo);
    }
}
