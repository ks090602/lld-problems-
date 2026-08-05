package com.example.fooddelivery.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.fooddelivery.enums.OrderStatus;

public class Order {
    private static final AtomicInteger autoId = new AtomicInteger(0);
    private final int id;
    private String userId;
    private String restaurantId;
    private double orderTotal;
    private List<OrderItem> orderedItems;
    private LocalDateTime timeStamp;
    private OrderStatus status;
    
    public Order(String userId, String restaurantId,List<OrderItem> orderedItems) {
        this.id = autoId.incrementAndGet();
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.orderedItems = orderedItems;
        this.timeStamp = LocalDateTime.now();
        this.status = OrderStatus.PLACED;
        this.orderTotal = orderedItems.stream().mapToDouble(o->o.getTotalPrice()).sum();
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public List<OrderItem> getOrderedItems() {
        return orderedItems;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public OrderStatus getStatus() {
        return status;
    } 
    
    public void orderFailed()
    {
        this.status = OrderStatus.FAILED;
    }
    
    public void orderCancelled()
    {
        this.status = OrderStatus.CANCELLED;
    }
    
    public void orderCompleted()
    {
        this.status = OrderStatus.COMPLETED;
    }
    
}
