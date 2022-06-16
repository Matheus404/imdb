package com.ioasys.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ioasys.imdb.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
}
