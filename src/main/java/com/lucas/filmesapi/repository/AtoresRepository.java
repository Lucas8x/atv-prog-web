package com.lucas.filmesapi.repository;

import com.lucas.filmesapi.domain.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtoresRepository extends JpaRepository<Ator, Long>{
  
}
