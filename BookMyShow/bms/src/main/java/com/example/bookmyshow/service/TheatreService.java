package com.example.bookmyshow.service;

import com.example.bookmyshow.model.Theatre;
import com.example.bookmyshow.repository.TheatreRepository;

public class TheatreService {
    private final TheatreRepository theatreRepo;

    public TheatreService(TheatreRepository theatreRepository)
    {
        this.theatreRepo = theatreRepository;
    }

    public Theatre createTheatre(String name)
    {
        Theatre theatre = new Theatre(name);
        theatreRepo.save(theatre);
        return theatre;
    }

    public Theatre getTheatre(int theatreID)
    {
        return theatreRepo.get(theatreID);
    }
}
