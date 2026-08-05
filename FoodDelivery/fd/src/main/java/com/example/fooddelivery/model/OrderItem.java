package com.example.fooddelivery.model;

public class OrderItem {
    private final String menuItemId;
    private final String itemName;
    private final double priceAtPurchase;
    private final int quantity;
    private final double totalPrice;

    public OrderItem(String menuItemId, String itemName, double priceAtPurchase, int quantity) {
        this.menuItemId = menuItemId;
        this.itemName = itemName;
        this.priceAtPurchase = priceAtPurchase;
        this.quantity = quantity;
        this.totalPrice = priceAtPurchase*quantity;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }



}
