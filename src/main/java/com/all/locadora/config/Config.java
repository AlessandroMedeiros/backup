package com.all.locadora.config;

import com.all.locadora.service.BancoDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("locadora4all")
public class Config {

    @Autowired
    private BancoDadosService locadoraService;

    @Bean
    public boolean populaBanco() throws ParseException {
        locadoraService.insereBanco();
        return true;
    }
}
