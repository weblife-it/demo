package com.demo.programmazione.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;

import com.demo.programmazione.model.Programmazione;
import com.demo.programmazione.service.ProgrammazioneService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class ProgrammazioneController {
	@Autowired   
    private ProgrammazioneService service;
     
    @GetMapping
    public String getDescrizione() {
        return "Cinema “CineMille: gestione della programmazione dei film”";
    }
    
    @GetMapping("/storico")
    public List<Programmazione> getStorico() {
        return service.getStorico();
    }
    
    @GetMapping("/programmazione")
    public List<Programmazione> getProgrammazione() {
        return getProgrammazione(null, null);
    }
    
    @GetMapping("/programmazione/{dataInizio}/{dataFine}")
    public List<Programmazione> getProgrammazione(@PathVariable Date dataInizio, @PathVariable Date dataFine) {
            	
        return service.getProgrammazione(dataInizio, dataFine);
    }
    
    @GetMapping("/programmazione/{id}")
    public ResponseEntity<Programmazione> getProgrammazioneById(@PathVariable long id) {
        Optional<Programmazione> film = service.getFilmById(id);

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
