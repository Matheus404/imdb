package com.ioasys.imdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioasys.imdb.model.Movie;
import com.ioasys.imdb.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> listMovie() {
		List<Movie> movies = movieService.findAllMovie();
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	@PutMapping("/id")
	public ResponseEntity<?> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
		movieService.updateMovie(id, movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/vote")
	public ResponseEntity<?> vote(@PathVariable Long id, double userNote) {
		return new ResponseEntity<>(movieService.voteMovie(id, userNote), HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
