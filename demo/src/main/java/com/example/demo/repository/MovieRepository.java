package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	/*
	  List<Movie> findByDirector(String director); // Trova film per regista
    	List<Movie> findByYear(int year); // Trova film per anno
	 */
	
	
}
