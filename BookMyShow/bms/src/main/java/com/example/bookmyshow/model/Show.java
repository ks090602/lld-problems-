package com.example.bookmyshow.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Show {
    private static final AtomicInteger autoID = new AtomicInteger(0);
    private final int id;
    private final Movie movie;
    private final Theatre theatre;
    private final Screen screen;
    private final LocalDateTime start;
    private final LocalDateTime end;

    public Show(Movie movie, Theatre theatre, Screen screen, LocalDateTime start, LocalDateTime end) {
        this.id = autoID.incrementAndGet();
        this.movie = movie;
        this.theatre = theatre;
        this.screen = screen;
        this.start = start;
        this.end = end;
    }

    
    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

}
