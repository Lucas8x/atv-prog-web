package com.lucas.filmesapi.repository;

import com.lucas.filmesapi.domain.Genero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerosRepository extends JpaRepository<Genero, Long> {
  
}
