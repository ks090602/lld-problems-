package com.example.fooddelivery.model;

public class CartItem {
    private final MenuItem menuItem;
    private int quantity;

    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
    public int getQuantity() {
        return quantity;
    }
    
    public void increaseQuantity(int quantity)
    {
        this.quantity+=quantity;
    }

    public void decreaseQuantity(int quantity)
    {
        if(this.quantity<quantity) throw new IllegalStateException("Cant decrease zero quntity");
        this.quantity-=quantity;
    }
}
