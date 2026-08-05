package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Order;

public class DeliveryService {
    public void deliverOrder(Order order)
    {
        System.out.println("Order is out for delivery to : " + order.getUserId() + " From Restaurant id: " + order.getRestaurantId());
    }

    public boolean isOrderDelivered(Order order)
    {
        System.out.println("Order is succesfully delivered to : " + order.getUserId() + " From Restaurant id: " + order.getRestaurantId());
        return true;
    }
}
