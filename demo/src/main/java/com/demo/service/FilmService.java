package com.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Film;
import com.demo.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired
	private FilmRepository repository;
    
    public List<Film> getStorico() {    	
        return repository.findAll();
    }
    
    public List<Film> getProgrammazione(Date dataInizio, Date dataFine) {    	
        return repository.findFilmByDateBetween(dataInizio, dataFine);
    } 
        
    public Optional<Film> getFilmById(Long id) {
        return repository.findById(id);
    }
    
    /* public Film saveFilm(Film film) {
        return repository.save(film);
    }

    public void deleteFilm(Long id) {
        repository.deleteById(id);
    }*/
    
}
