package com.example.bookmyshow.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Theatre {
    private static final AtomicInteger autoID = new AtomicInteger(0);
    private int id;
    private String name;
    private Map<Integer,Screen> screens;

    public Theatre(String name)
    {
        this.id = autoID.incrementAndGet();
        this.name = name;
        this.screens = new ConcurrentHashMap<>();
    }

    public void addScreen(Screen screen)
    {
        try{
            screens.putIfAbsent(screen.getID(), screen);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Screen getScreen(int screenId) {
        return screens.get(screenId);
    }
}
