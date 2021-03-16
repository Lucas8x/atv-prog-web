package com.lucas.filmesapi.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generoID;
    @Column(length=150)
    private String nome;
    private String descricao;
    @OneToMany(mappedBy="genero")
    private List<Filme> filme;

    public Genero() {}

    public Genero(Long generoID, String nome, String descricao) {
        this.generoID = generoID;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getGeneroID() {
        return this.generoID;
    }

    public void setGeneroID(Long generoID) {
        this.generoID = generoID;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
