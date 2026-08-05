package com.example.fooddelivery.repo.orderrepo;

import java.util.HashMap;
import java.util.Map;

import com.example.fooddelivery.model.Order;

public class InMemoryOrderRepo implements IOrderRepo{
    private final Map<Integer,Order> orders = new HashMap<>(); 

    @Override
    public Order save(Order order)
    {
        return orders.put(order.getId(),order);
    }

    @Override
    public Order get(int orderId)
    {
        return orders.get(orderId);
    }
}
