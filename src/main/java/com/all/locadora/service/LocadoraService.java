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

@Service
public class LocadoraService {

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
        FilmeModel f3 = new FilmeModel("Carga Explosiva", "Louis Leterrier",3);
        FilmeModel f4 = new FilmeModel("Velos e Furioso desafio em Tóqui", "Justin Lin",4);
        FilmeModel f5 = new FilmeModel("Missão Impossível: Protocolo Fantasma", "Brad Bird",5);
        filmeRepository.saveAll(Arrays.asList(f1,f2,f3,f4,f5));

        UsuarioModel usu1 = new UsuarioModel("alessandro@email.com", "Alessandro", "1234");
        UsuarioModel usu2 = new UsuarioModel("joao@email.com", "Joao", "jojo");
        usuarioRepository.saveAll(Arrays.asList(usu1,usu2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        LocacaoModel locacaoModel = new LocacaoModel(1, sdf.parse("02/10/2019 17:18"));

        locacaoRepository.save(locacaoModel);

        ItemLocacao itemLocacao1 = new ItemLocacao(locacaoModel, f1, 1);
        locacaoModel.getItens().add(itemLocacao1);
        f1.getItens().addAll(Arrays.asList(itemLocacao1));

        itemLocacaoRepository.save(itemLocacao1);

    }
}
