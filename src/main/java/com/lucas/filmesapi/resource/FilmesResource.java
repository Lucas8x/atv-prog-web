package com.lucas.filmesapi.resource;

import java.net.URI;
import java.util.List;

import com.lucas.filmesapi.domain.Filme;
import com.lucas.filmesapi.repository.FilmesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/filmes")
public class FilmesResource {
  @Autowired
  private FilmesRepository filmesRepository;

  @GetMapping
  public List<Filme> listar() {
    return filmesRepository.findAll();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Filme> buscarPorID(@PathVariable("id") Long FilmeID) {
    return filmesRepository.findById(FilmeID)
      .map(ator ->
        ResponseEntity.ok(ator))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Void> criar(@RequestBody Filme filme) {
    filmesRepository.save(filme);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(filme.getFilmeID()).toUri();
  return ResponseEntity.created(uri).build();

  }

  @PutMapping
  public void atualizar(@RequestBody Filme filme) {
    filmesRepository.save(filme);
  }

  @DeleteMapping
  public void deletar(@RequestBody Filme filme) {
    filmesRepository.delete(filme);
  }
}
