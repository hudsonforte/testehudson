package com.texoit.testehudson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texoit.testehudson.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	public List<Movie> findByWinner(boolean win);
}