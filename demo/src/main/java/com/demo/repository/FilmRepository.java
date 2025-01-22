package com.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Film;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
	
	
	@Query("SELECT f FROM Film f WHERE f.data BETWEEN :dataInizio AND :dataFine")
    List<Film> findFilmByDateBetween(@Param("dataInizio") Date dataInizio, @Param("dataFine") Date dataFine);
		
}
