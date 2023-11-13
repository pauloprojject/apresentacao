package com.example.apresetacao.dtos;

import java.sql.Timestamp;
import java.util.Date;

import com.example.apresetacao.model.Produto;

public class ProdutoDTO {
    private Long id;
    private Double preco;
    private String nome;
    private boolean deleted;
    private Date created;
    private Date updated;

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        preco = produto.getPreco();
        nome = produto.getNome();
        deleted = produto.isDeleted();
        created = produto.getCreated();
        updated = produto.getUpdated();
    }

    public ProdutoDTO(Long id, Double preco, String nome, boolean deleted, Timestamp created, Timestamp updated) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
        this.deleted = deleted;
        this.created = created;
        this.updated = updated;
    }

    public ProdutoDTO() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    
}
