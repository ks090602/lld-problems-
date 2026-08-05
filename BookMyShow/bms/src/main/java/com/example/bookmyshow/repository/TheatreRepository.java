package com.example.bookmyshow.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.bookmyshow.model.Theatre;

public class TheatreRepository {
    private Map<Integer, Theatre> map = new HashMap<>();

    public void save(Theatre theatre)
    {
        map.put(theatre.getId(), theatre);
    }

    public Theatre get(int theatreID){
        return map.get(theatreID);
    }

    public void delete(Theatre theatre)
    {
        map.remove(theatre.getId());
    }

}
