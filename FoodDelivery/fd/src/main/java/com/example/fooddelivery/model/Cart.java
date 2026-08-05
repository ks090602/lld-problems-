package com.example.fooddelivery.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> cartItems = new ArrayList<>();
    private double cartTotal;

    public Cart() {
        cartTotal = 0.0;
    }

    public void addToCart(CartItem cartItem)
    {
        cartItems.add(cartItem);
        updateTotal(cartItem.getMenuItem().getPrice()*cartItem.getQuantity());
    }

    public void removeFromCart(CartItem cartItem, int quantityToRemove)
    {
        try{cartItem.decreaseQuantity(quantityToRemove);}
        catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
        if(cartItem.getQuantity()==0){
            cartItems.remove(cartItem);
        }
        updateTotal(-(cartItem.getMenuItem().getPrice()*quantityToRemove));
    }

    public List<CartItem> getCartItems(){
        return cartItems;
    }

    private void updateTotal(double amount){
        cartTotal+=amount;
    }

    public double getTotal(){
        return cartTotal;
    }

    
}
