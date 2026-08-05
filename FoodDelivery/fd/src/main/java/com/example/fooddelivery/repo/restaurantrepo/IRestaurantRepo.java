package com.example.fooddelivery.repo.restaurantrepo;

import java.util.List;

import com.example.fooddelivery.model.Restaurant;

public interface IRestaurantRepo {
    Restaurant save(Restaurant r);
    Restaurant get(String rId);
    void remove(String rId);
    List<Restaurant> getAllRestaurants();
}
