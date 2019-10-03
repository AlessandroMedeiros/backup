package com.all.locadora.controller;

import com.all.locadora.controller.dto.LocacaoDTO;
import com.all.locadora.model.LocacaoModel;
import com.all.locadora.service.BancoDadosService;
import com.all.locadora.service.LocadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locacao")
public class LocadoraController {

    @Autowired
    LocadoraService locadoraService;

    @PostMapping("/locar")
    public void locacaoFilme(@RequestBody LocacaoDTO locacaoDTO) {
        LocacaoModel locacaoModel = locadoraService.locarFilme(locacaoDTO);




//        Optional<FilmeModel> listaFilme = filmeRepository.findById(idFilme);
//
//        int quantidadeDeFilmes = listaFilme.get().getQuantidade();
//        if(quantidadeDeFilmes>0){
//            listaFilme.get().setQuantidade(quantidadeDeFilmes-1);
//            filmeRepository.save(listaFilme.get());
//
//            System.out.println("Filme " + listaFilme.get().getTitulo() + " alugado com sucesso!");
//        }else{
//            System.out.println("Quantidade de filmes esgotada!");
//        }
    }

    @PostMapping("/{id}/devolver")
    public void devolucaoFilme(@PathVariable Integer idLocacao){
//        Optional<FilmeModel> listaFilme = filmeRepository.findById(idLocacao);
//
//        int quantidadeDeFilmes = listaFilme.get().getQuantidade();
//        listaFilme.get().setQuantidade(quantidadeDeFilmes+1);
//        filmeRepository.save(listaFilme.get());
//        System.out.println("Filme " + listaFilme.get().getTitulo() + " devolvido com sucesso!");
    }
}
