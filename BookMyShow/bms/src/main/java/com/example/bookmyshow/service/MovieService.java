package com.example.bookmyshow.service;

import com.example.bookmyshow.model.Movie;
import com.example.bookmyshow.repository.MovieRepository;

public class MovieService {
    private final MovieRepository movieRepo;

    public MovieService(MovieRepository movieRepository)
    {
        this.movieRepo = movieRepository;
    }

    public Movie createMovie(String title, int runtimeInMins, double extraPrice)
    {
        Movie newMovie = new Movie(title, runtimeInMins, extraPrice);
        movieRepo.save(newMovie);
        return newMovie;
    }

    public Movie getMovie(int movieID)
    {
        return movieRepo.get(movieID);
    }
}
