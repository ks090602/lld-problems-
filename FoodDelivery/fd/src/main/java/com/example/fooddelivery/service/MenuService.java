package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Menu;
import com.example.fooddelivery.model.MenuItem;

public class MenuService {
    private final Menu menu;

    public MenuService(Menu menu)
    {
        this.menu = menu;
    }

    public void addMenuItem(MenuItem mItem)
    {
        menu.add(mItem);
    }
    public void removeMenuItem(String id)
    {
        menu.remove(id);
    }
    
    public MenuItem getMenuItem(String id)
    {
        MenuItem menuItem = menu.get(id);
        if(menuItem==null)
        {
            throw new IllegalStateException("No Such Menu Item Found");
        }
        return menuItem;
    } 

    public void updatePrice(String id,double newPrice)
    {
        try{
            MenuItem menuItem = getMenuItem(id);
            menuItem.setPrice(newPrice);
        }catch(IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void updateAvailableQuantity(String id,int quantity)
    {
        try{
            MenuItem menuItem = getMenuItem(id);
            menuItem.setAvailableQuantity(quantity);
        }catch(IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public boolean reserve(String id,int quantity)
    {
        try{
            MenuItem menuItem = getMenuItem(id);
            return menuItem.reserve(quantity);
        }catch(IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void releaseReservation(String id,int quantity)
    {
        try{
            MenuItem menuItem = getMenuItem(id);
            menuItem.releaseReserve(quantity);
        }catch(IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void consumeReservation(String id,int quantity)
    {
        try{
            MenuItem menuItem = getMenuItem(id);
            menuItem.consumeReservation(quantity);
        }catch(IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
