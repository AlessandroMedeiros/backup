package com.all.locadora.service;

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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BancoDadosService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ItemLocacaoRepository itemLocacaoRepository;

    @Autowired
    private LocacaoRepository locacaoRepository;

    public void insereBanco() throws ParseException {

        FilmeModel f1 = new FilmeModel("Tropa de Elite", "José Padilha", 1);
        FilmeModel f2 = new FilmeModel("Matrix", "Lilly Wachowski", 2);
        FilmeModel f3 = new FilmeModel("Carga Explosiva", "Louis Leterrier", 3);
        FilmeModel f4 = new FilmeModel("Velos e Furioso desafio em Tóqui", "Justin Lin", 4);
        FilmeModel f5 = new FilmeModel("Missão Impossível: Protocolo Fantasma", "Brad Bird", 5);
        filmeRepository.saveAll(Arrays.asList(f1, f2, f3, f4, f5));

        UsuarioModel usu1 = new UsuarioModel("alessandro@email.com", "Alessandro", "$2a$10$1fDOld8RXSGCd8K/ozFdFuGr5g6DU9240b0bysJwy8GA9yHY6.z.q");
        UsuarioModel usu2 = new UsuarioModel("anderson@email.com", "Anderson", "andi");
        UsuarioModel usu3 = new UsuarioModel("andre@email.com", "Andre", "dede");
        usuarioRepository.saveAll(Arrays.asList(usu1, usu2, usu3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        LocacaoModel locacao1 = new LocacaoModel(sdf.parse("03/10/2019 10:46"), usu1);
        LocacaoModel locacao2 = new LocacaoModel(sdf.parse("03/10/2019 14:11"), usu2);

        List<LocacaoModel> loc = locacaoRepository.saveAll(Arrays.asList(locacao1, locacao2));

        ItemLocacao itemLocacao1 = new ItemLocacao(locacao1, f1);
        ItemLocacao itemLocacao2 = new ItemLocacao(locacao2, f2);

        locacao1.getItens().add(itemLocacao1);
        locacao2.getItens().add(itemLocacao2);

        f1.getItens().addAll(Collections.singletonList(itemLocacao1));
        f2.getItens().addAll(Collections.singletonList(itemLocacao2));

        itemLocacaoRepository.saveAll(Arrays.asList(itemLocacao1, itemLocacao2));
        List<ItemLocacao> lista = itemLocacaoRepository.findByLocacao(loc.get(0));
        List<ItemLocacao> lista2 = itemLocacaoRepository.findByLocacao(loc.get(1));

    }
}
