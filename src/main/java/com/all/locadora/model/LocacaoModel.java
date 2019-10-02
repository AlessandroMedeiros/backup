package com.all.locadora.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locacao")
public class LocacaoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private Date instante;

    @Column(name = "usuario")
    private UsuarioModel usuarioModel;

    @OneToMany(mappedBy="id.locacao")
    private Set<ItemLocacao> itens = new HashSet<>();

    public LocacaoModel() {
    }

    public LocacaoModel(Integer id, Date instante) {
        this.id = id;
        this.instante = instante;
        //this.usuarioModel = usuarioModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public Set<ItemLocacao> getItens() {
        return itens;
    }

    public void setItens(Set<ItemLocacao> itens) {
        this.itens = itens;
    }
}
