package com.all.locadora.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "filme")
public class FilmeModel {

    public FilmeModel(String titulo, String diretor) {
        this.titulo = titulo;
        this.diretor = diretor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "titulo")
    private String titulo;

    @NotNull
    @Column(name = "diretor")
    private String diretor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
