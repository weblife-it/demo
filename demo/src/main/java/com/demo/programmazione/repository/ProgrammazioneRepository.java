package com.demo.programmazione.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.programmazione.model.Programmazione;


@Repository
public interface ProgrammazioneRepository extends JpaRepository<Programmazione, Long> {
	
	
	@Query("SELECT p FROM Programmazione p JOIN FETCH p.film WHERE p.data BETWEEN :dataInizio AND :dataFine")
    List<Programmazione> findProgrammazioneByDateBetween(@Param("dataInizio") Date dataInizio, @Param("dataFine") Date dataFine);
	
}
