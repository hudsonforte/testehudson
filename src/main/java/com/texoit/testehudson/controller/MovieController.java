package com.texoit.testehudson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.texoit.testehudson.domain.Movie;
import com.texoit.testehudson.service.MovieService;


@RestController
@RequestMapping("/movie")
public class MovieController {

	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> findAllMovies(){
		return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK); 
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Movie> insertMovie(@RequestBody Movie newMovie){
		return new ResponseEntity<>(movieService.saveMovie(newMovie), HttpStatus.OK); 
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMovie(@PathVariable Long id){
		movieService.deleteMovie(id); 
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie newMovie, @PathVariable Long id){
		return new ResponseEntity<>(movieService.updateMovie(newMovie, id), HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Movie> findMovie(@PathVariable Long id){
		return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK); 
	}
	
}