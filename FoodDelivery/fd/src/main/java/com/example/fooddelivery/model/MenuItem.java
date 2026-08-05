package com.example.fooddelivery.model;

public class MenuItem {
    private final String id;
    private double price;
    private final FoodItem foodItem;
    private final String restaurantId;
    
    public String getRestaurantId() {
        return restaurantId;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    // Changed to standard primitives since we will synchronize access
    private int availableQuantity;
    private int reservedQuantity;

    public MenuItem(String id,double price, FoodItem foodItem, int availableQuantity,String restaurantId) {
        this.id = id;
        this.price = price;
        this.foodItem = foodItem;
        this.availableQuantity = availableQuantity;
        this.reservedQuantity = 0;
        this.restaurantId = restaurantId;
    }

    public String getId(){
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Must be synchronized so threads don't read halfway-updated values
    public synchronized int getAvailableQuantity() {
        return availableQuantity;
    }

    public synchronized void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public synchronized int getReservedQuantity() {
        return reservedQuantity;
    }

    public synchronized boolean reserve(int quantity) {
        // Validation: Prevent reserving more than we have
        if (availableQuantity >= quantity) {
            reservedQuantity += quantity;
            availableQuantity -= quantity;
            return true; // Reservation successful
        }
        return false; // Not enough available
    }

    public synchronized void releaseReserve(int quantity) {
        reservedQuantity -= quantity;
        availableQuantity += quantity;
    }

    public synchronized void consumeReservation(int quantity) {
        reservedQuantity -= quantity;
    }

    public boolean isAvailable(){
        return availableQuantity>0;
    }
}