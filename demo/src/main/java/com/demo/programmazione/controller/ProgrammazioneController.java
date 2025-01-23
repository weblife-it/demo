package com.demo.programmazione.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.programmazione.ProgrammazioneApplication;
import com.demo.programmazione.model.Programmazione;
import com.demo.programmazione.service.ProgrammazioneService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/demo")
@Tag(name = "API Programmazione film", description = "API per la visualizzazione della programmazione dei film")
public class ProgrammazioneController {
	@Autowired   
    private ProgrammazioneService service;
     
    @GetMapping
    @Operation(summary = "Descrizione dell'applicazione", description = "Gestione programmazione film")
    //@ApiResponse(responseCode = "200", description = "Operazione completata con successo")
    public String getDescrizione() {
        return ProgrammazioneApplication.INFO;
    }
        
    @GetMapping("/programmazione")
    @Operation(summary = "Programmazione settimanale", description = "Produce la programmazione della settimana in corso da lunedì a domenica")
    public List<Programmazione> getProgrammazione() {
        return service.getProgrammazione(null, null);
    }
    
    @GetMapping("/programmazione/{dataInizio}/{dataFine}")
    @Operation(summary = "Programmazione per periodo", description = "Produce la programmazione reperibile tra due date")
    public List<Programmazione> getProgrammazione(@PathVariable Date dataInizio, @PathVariable Date dataFine) {
            	
        return service.getProgrammazione(dataInizio, dataFine);
    }

    @GetMapping("/storico")
    @Operation(summary = "Storico programmazione", description = "Produce tutta la programmazione disponibile")
    public List<Programmazione> getStorico() {
        return service.getStorico();
    }
    
    @GetMapping("/storico/{id}")
    @Operation(summary = "Storico specifico", description = "Produce la programmazione relativa a uno specifico identificativo")
    public ResponseEntity<Programmazione> getProgrammazioneById(@PathVariable long id) {
        Optional<Programmazione> film = service.getProgrammazioneById(id);

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
