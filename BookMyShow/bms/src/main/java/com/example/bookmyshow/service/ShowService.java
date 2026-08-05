package com.example.bookmyshow.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.bookmyshow.model.Movie;
import com.example.bookmyshow.model.Screen;
import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.Theatre;
import com.example.bookmyshow.repository.ShowRepository;

public class ShowService {
    private final ShowRepository showRepo;

    public ShowService(ShowRepository showRepository)
    {
        this.showRepo = showRepository;
    }

    public Show createShow(Movie movie, Theatre theatre, Screen screen, LocalDateTime start, LocalDateTime end)
    {
        Show newShow = new Show(movie, theatre, screen, start, end);
        showRepo.save(newShow);
        return newShow;
    }

    public Show getShow(int showID)
    {
        return showRepo.get(showID);
    }

    public List<Show> getShowsByMovieTitle(String title)
    {
        return showRepo.getAll().stream().filter(show -> show.getMovie().getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }
}
