package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /*
      @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
     */
    
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
