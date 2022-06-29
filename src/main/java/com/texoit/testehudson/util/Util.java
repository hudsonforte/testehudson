package com.texoit.testehudson.util;

import java.util.List;

import com.texoit.testehudson.domain.Movie;


public class Util {

    private Movie getNextMovie(List<Movie> winningMovies, Movie currentMovie) {
        int index = winningMovies.indexOf(currentMovie);
        if (index < 0 || index + 1 == winningMovies.size()) {
            return null;
        }
        return winningMovies.get(index + 1);
    }
	
}