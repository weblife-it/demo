package com.demo.service;

import java.sql.Date;
import java.util.Calendar;
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
    	
    	if(dataInizio==null){
            Calendar cal = Calendar.getInstance();
            cal.setFirstDayOfWeek(Calendar.MONDAY);
            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
            dataInizio=new Date(cal.getTimeInMillis());
            System.out.println("Inizio: "+dataInizio);
    	}
    	
    	if(dataFine==null) {
            Calendar cal = Calendar.getInstance();
            cal.setFirstDayOfWeek(Calendar.MONDAY);
            int giorniFinoDomenica = Calendar.SUNDAY - cal.get(Calendar.DAY_OF_WEEK);
            if (giorniFinoDomenica <= 0) {
                giorniFinoDomenica += 7;
            }
            cal.add(Calendar.DAY_OF_WEEK, giorniFinoDomenica);
            
    		dataFine=new Date(cal.getTimeInMillis());
    		System.out.println("Fine: "+dataFine);
    	}
    	
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
