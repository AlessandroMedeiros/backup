package com.all.locadora.service;

import com.all.locadora.model.FilmeModel;
import com.all.locadora.model.UsuarioModel;
import com.all.locadora.repository.FilmeRepository;
import com.all.locadora.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LocadoraService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void insereBanco(){

        FilmeModel f1 = new FilmeModel("Tropa de Elite", "José Padilha", 0);
        FilmeModel f2 = new FilmeModel("Matrix", "Lilly Wachowski", 1);
        FilmeModel f3 = new FilmeModel("Carga Explosiva", "Louis Leterrier",2);
        FilmeModel f4 = new FilmeModel("Velos e Furioso desafio em Tóqui", "Justin Lin",3);
        FilmeModel f5 = new FilmeModel("Missão Impossível: Protocolo Fantasma", "Brad Bird",4);
        filmeRepository.saveAll(Arrays.asList(f1,f2,f3,f4,f5));

        UsuarioModel usu1 = new UsuarioModel("alessandro@email.com", "Alessandro", "1234");
        UsuarioModel usu2 = new UsuarioModel("joao@email.com", "Joao", "jojo");
        usuarioRepository.saveAll(Arrays.asList(usu1,usu2));
    }
}
