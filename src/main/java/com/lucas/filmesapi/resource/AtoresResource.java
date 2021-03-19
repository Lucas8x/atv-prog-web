package com.lucas.filmesapi.resource;

import java.net.URI;
import java.util.List;

import com.lucas.filmesapi.domain.Ator;
import com.lucas.filmesapi.repository.AtoresRepository;

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
@RequestMapping("/atores")
public class AtoresResource {
  @Autowired
  private AtoresRepository atoresRepository;

  @GetMapping
  public List<Ator> listar() {
    return atoresRepository.findAll();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Ator> buscarPorID(@PathVariable("id") Long AtorID) {
    return atoresRepository.findById(AtorID)
      .map(ator -> ResponseEntity.ok(ator))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Void> criar(@RequestBody Ator ator) {
    atoresRepository.save(ator);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(ator.getAtorID()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping
  public void atualizar(@RequestBody Ator ator) {
    atoresRepository.save(ator);
  }

  @DeleteMapping
  public void deletar(@RequestBody Ator ator) {
    atoresRepository.delete(ator);
  }

}
