package com.all.locadora.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "senha")
    private String senha;

    public UsuarioModel() {
    }

    public UsuarioModel(Integer id, String email, String nome, String senha) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public UsuarioModel(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioModel)) return false;
        UsuarioModel that = (UsuarioModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, nome, senha);
    }
}
