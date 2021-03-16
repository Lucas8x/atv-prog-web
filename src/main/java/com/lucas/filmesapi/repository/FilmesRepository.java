package com.lucas.filmesapi.repository;

import com.lucas.filmesapi.domain.Filme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<Filme, Long>{
  
}
