package com.lucas.filmesapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "filme_ator")
public class FilmeAtor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name="filmeID", referencedColumnName="filmeID")
  private Filme filme;
  @ManyToOne
  @JoinColumn(name="atorID", referencedColumnName="atorID")
  private Ator ator;

  public FilmeAtor() {}

  public FilmeAtor(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Filme getFilme() {
    return filme;
  }

  public void setFilme(Filme filme) {
    this.filme = filme;
  }

  public Ator getAtor() {
    return ator;
  }

  public void setAtor(Ator ator) {
    this.ator = ator;
  }
}
