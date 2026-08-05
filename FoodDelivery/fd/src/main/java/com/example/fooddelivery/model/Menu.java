package com.example.fooddelivery.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private final Map<String,MenuItem> menuItems;

    public Menu()
    {
        menuItems = new HashMap<>();
    }

    public void add(MenuItem menuItem)
    {
        menuItems.put(menuItem.getId(), menuItem);
    }

    public void remove(String id)
    {
        menuItems.remove(id);
    }

    public MenuItem get(String id)
    {
        return menuItems.get(id);
    }

    public List<MenuItem> getAllMenuItems()
    {
        return new ArrayList<>(menuItems.values());
    }



}
