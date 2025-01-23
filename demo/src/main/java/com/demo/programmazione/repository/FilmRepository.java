package com.demo.programmazione.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.programmazione.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
}

