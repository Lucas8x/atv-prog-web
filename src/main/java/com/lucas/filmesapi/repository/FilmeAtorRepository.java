package com.lucas.filmesapi.repository;

import com.lucas.filmesapi.domain.FilmeAtor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeAtorRepository extends JpaRepository<FilmeAtor, Long>{
  
}
