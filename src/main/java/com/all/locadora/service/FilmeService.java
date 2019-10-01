package com.all.locadora.service;

import com.all.locadora.model.FilmeModel;
import com.all.locadora.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public void insereFilme(){

        FilmeModel f1 = new FilmeModel("Tropa de Elite", "José Padilha");
        FilmeModel f2 = new FilmeModel("Matrix", "Lilly Wachowski");
        FilmeModel f3 = new FilmeModel("Carga Explosiva", "Louis Leterrier");
        FilmeModel f4 = new FilmeModel("Velos e Furioso desafio em Tóqui", "Justin Lin");
        FilmeModel f5 = new FilmeModel("Missão Impossível: Protocolo Fantasma", "Brad Bird");

        filmeRepository.saveAll(Arrays.asList(f1,f2,f3,f4,f5));
    }
}
