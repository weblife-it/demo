package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;

import com.demo.model.Film;
import com.demo.service.FilmService;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class FilmController {
	@Autowired   
    private FilmService service;
     
    @GetMapping
    public String getDescrizione() {
        return "Cinema “CineMille: gestione della programmazione dei film”";
    }
    
    @GetMapping("/storico")
    public List<Film> getStorico() {
        return service.getStorico();
    }
    
    @GetMapping("/programmazione")
    public List<Film> getProgrammazione() {
        return getProgrammazione(null, null);
    }
    
    @GetMapping("/programmazione/{dataInizio}/{dataFine}")
    public List<Film> getProgrammazione(@PathVariable Date dataInizio, @PathVariable Date dataFine) {
            	
        return service.getProgrammazione(dataInizio, dataFine);
    }
    
    @GetMapping("/film/{id}")
    public ResponseEntity<Film> findFilmById(@PathVariable long id) {
        Optional<Film> film = service.getFilmById(id);

        if(film.isPresent()) {
            return ResponseEntity.ok().body(film.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        /*  return service.getFilmById(id)
            .map(film -> ResponseEntity.ok(film))
            .orElse(ResponseEntity.notFound().build()); */
        
    }

/*    
    @PostMapping
    public Movie saveMovie(@Validated @RequestBody Movie movie) {
        return service.save(movie);
    }
*/    
    
}
