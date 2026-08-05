package com.example.bookmyshow.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Movie {
    private static final AtomicInteger autoID = new AtomicInteger(0);
    private int id;
    private String title; 
    private int runtimeInMins; 
    private double extraPrice;

    public Movie(String title,int runtimeInMins,double extraPrice)
    {
        this.id = autoID.incrementAndGet();
        this.title = title;
        this.runtimeInMins = runtimeInMins;
        this.extraPrice = extraPrice;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRuntimeInMins() {
        return runtimeInMins;
    }

    public double getExtraPrice() {
        return extraPrice;
    }
    
}
