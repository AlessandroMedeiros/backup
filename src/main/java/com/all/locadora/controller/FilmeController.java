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

    @PostMapping("/{id}/locar")
    public void locacaoFilme(@PathVariable Integer id) {
        Optional<FilmeModel> listaFilme = filmeRepository.findById(id);

        int quantidadeDeFilmes = listaFilme.get().getQuantidade();
        if(quantidadeDeFilmes>0){
            listaFilme.get().setQuantidade(quantidadeDeFilmes-1);
            filmeRepository.save(listaFilme.get());
            System.out.println("Filme " + listaFilme.get().getTitulo() + " alugado com sucesso!");
        }else{
            System.out.println("Quantidade de filmes esgotada!");
        }
    }

    @PostMapping("/{id}/devolver")
    public void devolucaoFilme(@PathVariable Integer id){
        Optional<FilmeModel> listaFilme = filmeRepository.findById(id);

        int quantidadeDeFilmes = listaFilme.get().getQuantidade();
            listaFilme.get().setQuantidade(quantidadeDeFilmes+1);
            filmeRepository.save(listaFilme.get());
            System.out.println("Filme " + listaFilme.get().getTitulo() + " devolvido com sucesso!");
    }
}
