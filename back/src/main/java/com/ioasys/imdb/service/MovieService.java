package com.ioasys.imdb.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ioasys.imdb.model.Movie;
import com.ioasys.imdb.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public Movie findById(Long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		return movie.orElseThrow(() -> new ObjectNotFoundException("Filme não encontrado! Id: " + id, 
				Movie.class.getName()));
	}
	
	public List<Movie> findAllMovie() {
		return movieRepository.findAll();
	}
	
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}
	
	public Movie updateMovie(Long id, Movie movie) {
		Movie movieAux = findById(id);
		movieAux.setMovieName(movie.getMovieName());
		movieAux.setNote(movie.getNote());
		movieAux.setVoteCount(movie.getVoteCount());
		movieAux.setAverageGrade(movie.getAverageGrade());
		movieAux.setAuthor(movie.getAuthor());
		movieAux.setGenre(movie.getGenre());
		return movieRepository.save(movieAux);
	}
	
	public Movie voteMovie(Long id, double userNote) {
		Movie movie = findById(id);
		double note = movie.getNote();
		int voteCount = movie.getVoteCount();
		movie.setNote(note = note + userNote);
		movie.setVoteCount(voteCount = voteCount + 1);
		movie.setAverageGrade((note / voteCount));
		return movieRepository.save(movie);
	}
	
}
