package com.all.locadora.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ItemLocacao  implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemLocacaoPK id = new ItemLocacaoPK();

    private int quantidade;

    public ItemLocacao() {
    }

    public ItemLocacao(LocacaoModel locacaoModel, FilmeModel filmeModel ,int quantidade) {
        id.setLocacao(locacaoModel);
        id.setFilme(filmeModel);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
