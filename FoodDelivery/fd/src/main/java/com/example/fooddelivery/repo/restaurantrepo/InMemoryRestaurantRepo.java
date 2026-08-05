package com.example.fooddelivery.repo.restaurantrepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.fooddelivery.model.Restaurant;

public class InMemoryRestaurantRepo implements IRestaurantRepo{
    private final Map<String,Restaurant> restaurants;

    public InMemoryRestaurantRepo(){
        restaurants = new HashMap<>();
    }
    
    @Override
    public Restaurant save(Restaurant restaurant)
    {
        return restaurants.put(restaurant.getId(), restaurant);
    }

    @Override
    public Restaurant get(String restaurantId)
    {
        return restaurants.get(restaurantId);
    }

    @Override
    public void remove(String restaurantId)
    {
        restaurants.remove(restaurantId);
    }

    @Override
    public List<Restaurant> getAllRestaurants()
    {
        return new ArrayList<>(restaurants.values());
    }
}
