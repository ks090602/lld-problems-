package com.example.bookmyshow.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Screen {
    private static final AtomicInteger autoID = new AtomicInteger(0);
    private int id;
    private Map<String,Seat> seats;

    public Screen()
    {
        this.id = autoID.incrementAndGet();
        seats = new ConcurrentHashMap<>(); 
    }

    public void addSeat(Seat seat)
    {
        try{
            seats.putIfAbsent(seat.getID(), seat);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Seat> getSeats()
    {
        return new ArrayList<>(seats.values());
    }
    public int getID()
    {
        return id;
    }
    
}
