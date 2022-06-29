package com.texoit.testehudson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.texoit.testehudson.domain.Movie;

import com.texoit.testehudson.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}

	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);		
	}
	
	public Movie findById(long id) {
		return movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Movie not found "+id));
	}
	
	public Movie updateMovie(Movie newMovie, long id) {
		return movieRepository.findById(id).map(movie -> {
			movie.setProducer(newMovie.getProducer());
			movie.setStudio(newMovie.getStudio());
			movie.setTitle(newMovie.getTitle());
			movie.setWinner(newMovie.getWinner());
			movie.setYear(newMovie.getYear());
			return movieRepository.save(movie);
		}).orElseThrow(() -> new IllegalArgumentException("Movie not found "+id));
	}
	
	public void deleteMovie(long id) {
		movieRepository.deleteById(id);
	}
}