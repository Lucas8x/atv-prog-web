package com.lucas.filmesapi.resource;

import java.util.List;
import java.util.Optional;

import com.lucas.filmesapi.domain.FilmeAtor;
import com.lucas.filmesapi.repository.FilmeAtorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmeator")
public class FilmeAtorResource {
  @Autowired
  private FilmeAtorRepository filmeAtorRepository;

  @GetMapping
  public List<FilmeAtor> listar() {
    return filmeAtorRepository.findAll();
  }

  @PostMapping
  public void criar(@RequestBody FilmeAtor filmeAtor) {
    filmeAtorRepository.save(filmeAtor);
  }
}
