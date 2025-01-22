package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Movie;
import com.demo.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class MovieController {
	@Autowired   
    private MovieService movieService;
     
    @GetMapping
    public String getCinema() {
        return "Cinema “CineMille”";
    }
    
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable long id) {
        Optional<Movie> movie = movieService.getMovieById(id);

        if(movie.isPresent()) {
            return ResponseEntity.ok().body(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        /*  return movieService.getMovieById(id)
            .map(movie -> ResponseEntity.ok(movie))
            .orElse(ResponseEntity.notFound().build()); */
        
    }

/*    
    @PostMapping
    public Movie saveMovie(@Validated @RequestBody Movie movie) {
        return movieService.save(movie);
    }
*/    
    
}
