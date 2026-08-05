package com.example.fooddelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.fooddelivery.model.MenuItem;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.repo.restaurantrepo.IRestaurantRepo;
import com.example.fooddelivery.repo.restaurantrepo.InMemoryRestaurantRepo;

public class RestaurantManager {
    private final IRestaurantRepo restaurantRepo;
    public RestaurantManager()
    {
        restaurantRepo = new InMemoryRestaurantRepo();
    }

    public Restaurant save(Restaurant r)
    {
        return restaurantRepo.save(r);
    } 
    public Restaurant get(String rId)
    {
        Restaurant restaurant = restaurantRepo.get(rId);
        if(restaurant==null) throw new IllegalStateException("No Such Restaurant with Id: " + rId +  " Found in the database");
        return restaurant;
    }
    public void removeRestauarant(String rId)
    {
        restaurantRepo.remove(rId);
    }

    public List<Restaurant> findRestaurantsByName(String name)
    {
        List<Restaurant> allRestaurants = restaurantRepo.getAllRestaurants();
        List<Restaurant> filteredRestaurants = allRestaurants.stream().filter(r->r.getName().toLowerCase().contains(name)).collect(Collectors.toList());
        return filteredRestaurants;
    }

    public List<Restaurant> findRestaurantsByFoodName(String name)
    {
        List<Restaurant> allRestaurants = restaurantRepo.getAllRestaurants();
        List<Restaurant> filteredRestaurants = allRestaurants.stream().filter(r->r.getMenu().getAllMenuItems().stream().anyMatch(i->i.getFoodItem().getName().toLowerCase().contains(name))).collect(Collectors.toList());
        return filteredRestaurants;
    }

    public List<MenuItem> getMenu(String rId)
    {
        Restaurant r = this.get(rId);
        return r.getMenu().getAllMenuItems();
    }

}
