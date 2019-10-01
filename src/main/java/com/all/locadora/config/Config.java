package com.all.locadora.config;

import com.all.locadora.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("locadora4all")
public class Config {

    @Autowired
    private FilmeService filmeService;

    @Bean
    public boolean populaBanco() {
        filmeService.insereFilme();
        return true;
    }
}
