package com.lucas.filmesapi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atorID;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(length=1)
    private String sexo;
    private String biografia;

    public Ator() {}

    public Ator(Long atorID, String nome, Date dataNascimento, String sexo, String biografia) {
        this.atorID = atorID;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.biografia = biografia;
    }

    public Long getAtorID() {
        return atorID;
    }

    public void setAtorID(long atorID) {
        this.atorID = atorID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
