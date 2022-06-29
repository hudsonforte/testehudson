package com.texoit.testehudson.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texoit.testehudson.domain.Movie;
import com.texoit.testehudson.domain.Producer;
import com.texoit.testehudson.dto.AwardResponse;
import com.texoit.testehudson.repository.MovieRepository;
import com.texoit.testehudson.util.Util;

@Service
public class ProducerService {

	
	private static final Integer INTERVAL =2;
	
	@Autowired
	private MovieRepository movieRepository;
	
	public AwardResponse getProducerAwards() {
		List<Movie> moviesList = movieRepository.findByWinner(true);
		Map<String, List<Movie>> moviesByProducer = moviesList.stream().collect(Collectors.groupingBy(Movie::getProducer));
		
		List<Producer> producers = new ArrayList<>();
		
		moviesByProducer.forEach((producer,movies) -> {
			movies.sort(Comparator.comparing(Movie::getYear));
            if (movies.size() >= INTERVAL) {
                movies.forEach(movie -> {
                    Movie nextMovie = getNextMovie(movies, movie);
                    if (nextMovie != null) {
                        Producer p = new Producer();
                        p.setProducer(producer);
                        p.setPreviousWin(movie.getYear());
                        p.setFollowingWin(nextMovie.getYear());
                        p.setInterval(p.getFollowingWin() - p.getPreviousWin());
                        producers.add(p);
                    }
                });
            }
		});
		
        List<Producer> minProducers = producers.stream().filter(
                producerMin -> producerMin.getInterval().equals(
                        producers.stream()
                                .min(Comparator.comparing(Producer::getInterval))
                                .orElseThrow(NoSuchElementException::new).getInterval()
                )
        ).collect(Collectors.toList());

        List<Producer> maxproducers = producers.stream().filter(
                producerMax -> producerMax.getInterval().equals(
                        producers.stream()
                                .max(Comparator.comparing(Producer::getInterval))
                                .orElseThrow(NoSuchElementException::new).getInterval()
                )
        ).collect(Collectors.toList());
        
        return new AwardResponse(minProducers, maxproducers);
	}
	
    private Movie getNextMovie(List<Movie> winningMovies, Movie currentMovie) {
        int index = winningMovies.indexOf(currentMovie);
        if (index < 0 || index + 1 == winningMovies.size()) {
            return null;
        }
        return winningMovies.get(index + 1);
    }
}