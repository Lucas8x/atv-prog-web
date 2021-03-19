package com.lucas.filmesapi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmeID;
    @Column(length=200)
    private String titulo;
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    private String sinopse;
    @OneToOne
    private Genero genero;

    public Filme() {}

    public Filme(Long filmeID, String titulo, Date dataLancamento, String sinopse) {
        this.filmeID = filmeID;
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.sinopse = sinopse;
    }

    public Long getFilmeID() {
        return filmeID;
    }

    public void setFilmeID(Long filmeID) {
        this.filmeID = filmeID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
