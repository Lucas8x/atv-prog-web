package com.lucas.filmesapi.resource;

import java.net.URI;
import java.util.List;

import com.lucas.filmesapi.domain.Genero;
import com.lucas.filmesapi.repository.GenerosRepository;

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
@RequestMapping("/generos")
public class GenerosResource {
  @Autowired
  private GenerosRepository generosRepository;

  @GetMapping
  public List<Genero> listar() {
    return generosRepository.findAll();
  }

  @GetMapping(value="/{id}")
  public ResponseEntity<Genero> buscarPorID(@PathVariable("id") Long generoID) {
    return generosRepository.findById(generoID)
      .map(genero -> ResponseEntity.ok(genero))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Void> criar(@RequestBody Genero genero) {
    generosRepository.save(genero);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(genero.getGeneroID()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @PutMapping
  public void atualizar(@RequestBody Genero genero) {
    generosRepository.save(genero);
  }

  @DeleteMapping
  public void deletar(@RequestBody Genero genero) {
    generosRepository.delete(genero);
  }
}
