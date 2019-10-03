package com.all.locadora.service;

import com.all.locadora.controller.dto.LocacaoDTO;
import com.all.locadora.model.FilmeModel;
import com.all.locadora.model.ItemLocacao;
import com.all.locadora.model.LocacaoModel;
import com.all.locadora.model.UsuarioModel;
import com.all.locadora.repository.FilmeRepository;
import com.all.locadora.repository.ItemLocacaoRepository;
import com.all.locadora.repository.LocacaoRepository;
import com.all.locadora.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LocadoraService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private ItemLocacaoRepository itemLocacaoRepository;

    public LocacaoModel locarFilme(LocacaoDTO locacaoDTO) {

        Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(locacaoDTO.getIdUsuario());
        LocacaoModel locacaoModel = new LocacaoModel();
        if (usuarioModel.isPresent()) {
            UsuarioModel usuario = usuarioModel.get();
            Optional<FilmeModel> filmeModel = filmeRepository.findById(locacaoDTO.getIdFilme());
            if (filmeModel.isPresent()) {
                FilmeModel filme = filmeModel.get();
                if (verificarDisponibilidadeFilme(filme)) {

                    boolean locar = true;
                    atualizarDisponibilidades(filme, locar);

                    locacaoModel.setId(null);
                    locacaoModel.setUsuarioModel(usuario);
                    locacaoModel.setInstante(new Date());
                    locacaoRepository.save(locacaoModel);

                    ItemLocacao itemLocacao = new ItemLocacao();
                    itemLocacao.setFilme(filme);
                    itemLocacao.setLocacao(locacaoModel);
                    locacaoModel.getItens().add(itemLocacao);
                    itemLocacaoRepository.saveAll(locacaoModel.getItens());
                }
                else{
                    System.out.println("Quantidade de filmes igual a ZERO!!");
                }
            }
        }
        return locacaoModel;
    }

    public void devolverFilme(LocacaoDTO locacaoDTO) {

        /*
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(locacaoDTO.getIdUsuario());
        LocacaoModel locacaoModel = new LocacaoModel();
        if (usuarioModel.isPresent()) {
            UsuarioModel usuario = usuarioModel.get();
            Optional<FilmeModel> filmeModel = filmeRepository.findById(locacaoDTO.getIdFilme());
            if (filmeModel.isPresent()) {
                FilmeModel filme = filmeModel.get();
                if (verificarDisponibilidadeFilme(filme)) {

                    boolean devolver = false;
                    atualizarDisponibilidades(filme, devolver);

                    locacaoModel.setId(null);
                    locacaoModel.setUsuarioModel(usuario);
                    locacaoModel.setInstante(new Date());
                    locacaoRepository.save(locacaoModel);

                    ItemLocacao itemLocacao = new ItemLocacao();
                    itemLocacao.setFilme(filme);
                    itemLocacao.setLocacao(locacaoModel);

                    locacaoModel.getItens().add(itemLocacao);
                    itemLocacaoRepository.saveAll(locacaoModel.getItens());
                }
                else{
                    System.out.println("Quantidade de filmes igual a ZERO!!");
                }
            }
        }
        return locacaoModel;
         */
    }

    private void atualizarDisponibilidades(FilmeModel filme, boolean atualizar) {
        if(atualizar){
            filme.setQuantidade(filme.getQuantidade()-1);
        }else{
            filme.setQuantidade(filme.getQuantidade()+1);
        }

        filmeRepository.save(filme);
    }

    private boolean verificarDisponibilidadeFilme(FilmeModel filme) {
        return filme.getQuantidade() > 0;
    }
}
