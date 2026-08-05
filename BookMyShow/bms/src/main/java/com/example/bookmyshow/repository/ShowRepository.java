package com.example.bookmyshow.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bookmyshow.model.Show;

public class ShowRepository {
    private Map<Integer,Show> map = new HashMap<>();

    public void save(Show show)
    {
        map.put(show.getId(), show);
    } 
    public Show get(int showID)
    {
        return map.get(showID);
    }

    public List<Show> getAll(){
        return new ArrayList<>(map.values());
    }


}
