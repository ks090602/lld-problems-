package com.example.fooddelivery.service;

import java.util.List;

import com.example.fooddelivery.model.Order;
import com.example.fooddelivery.model.OrderItem;
import com.example.fooddelivery.repo.orderrepo.IOrderRepo;
import com.example.fooddelivery.repo.orderrepo.InMemoryOrderRepo;

public class OrderService {
    private final IOrderRepo orderRepo;
    public OrderService()
    {
        this.orderRepo = new InMemoryOrderRepo();
    }

    public Order createOrder(String userId, String restaurantId,List<OrderItem> orderedItems)
    {
        Order newOrder = new Order(userId, restaurantId, orderedItems);
        orderRepo.save(newOrder);
        return newOrder;
    }

    public Order getOrder(int orderId){
        Order order = orderRepo.get(orderId);
        if(order==null) throw new IllegalStateException("No Such Order Found");
        return order;
    }
}
