package com.example.bookmyshow.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.bookmyshow.model.Movie;

public class MovieRepository {
    private Map<Integer,Movie> map = new HashMap<>();
    // CRUD
    
    public void save(Movie movie)
    {
        map.put(movie.getId(), movie);
    } 

    public Movie get(int movieId)
    {
        return map.get(movieId);
    }

    public void delete(Movie movie)
    {
        map.remove(movie.getId());
    }

}
