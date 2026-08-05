package com.example.fooddelivery.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.fooddelivery.enums.PaymentMethod;
import com.example.fooddelivery.model.Cart;
import com.example.fooddelivery.model.CartItem;
import com.example.fooddelivery.model.MenuItem;
import com.example.fooddelivery.model.Order;
import com.example.fooddelivery.model.OrderItem;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.model.User;

public class FoodDeliveryAppService {
    private final DeliveryService deliveryService;
    private final MenuService menuService;
    private final OrderService orderService;
    private final PaymentProcessor paymentProcessor;
    private final RestaurantManager restaurantManager;
    private final List<User> users;

    public FoodDeliveryAppService(DeliveryService deliveryService, MenuService menuService, OrderService orderService,
            PaymentProcessor paymentProcessor, RestaurantManager restaurantManager) {
        this.deliveryService = deliveryService;
        this.menuService = menuService;
        this.orderService = orderService;
        this.paymentProcessor = paymentProcessor;
        this.restaurantManager = restaurantManager;
        this.users = new ArrayList<>();
    }

    public void addUser(User u)
    {
        users.add(u);
    }

    public void removeUser(User u)
    {
        users.remove(u);
    }

    public List<Restaurant> getAllRestaurantsByName(String name)
    {
        return restaurantManager.findRestaurantsByName(name);
    }
    public List<Restaurant> getAllRestaurantsByFoodName(String name)
    {
        return restaurantManager.findRestaurantsByFoodName(name);
    }

    public List<MenuItem> getMenuItemsForARestauarnt(String rId)
    {
        return restaurantManager.getMenu(rId);
    }

    public Cart createCart(Map<MenuItem,Integer> selectedMenuItems)
    {
        // Map shows the selected menuitems by user and there quantity 
        Cart cart = new Cart();
        selectedMenuItems.forEach((m,q)->cart.addToCart(new CartItem(m, q)));
        return cart;
    }

    public void removeFromCart(Cart c,CartItem ci,int quantity)
    {
        c.removeFromCart(ci, quantity);
    }

    public void pay(String userId,Cart cart,PaymentMethod paymentMethod)
    {
        // reserving the stock before paying
       
        cart.getCartItems().forEach(c->menuService.reserve(c.getMenuItem().getId(), c.getQuantity()));
        if(paymentProcessor.pay(cart.getTotal(), paymentMethod)){
            // if payment successful consume reservation made in a thread safe manner 
            cart.getCartItems().forEach(c->menuService.consumeReservation(c.getMenuItem().getId(), c.getQuantity()));
        }
        else 
        {
            // if payment failed then release reservation made in a thread safe manner 
            cart.getCartItems().forEach(c->menuService.releaseReservation(c.getMenuItem().getId(), c.getQuantity()));
        }
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem c:cart.getCartItems())
        {
            OrderItem o = new OrderItem(c.getMenuItem().getId(), c.getMenuItem().getFoodItem().getName(), c.getMenuItem().getPrice(), c.getQuantity());
            orderItems.add(o);
        }
        generateOrder(userId, cart.getCartItems().get(0).getMenuItem().getRestaurantId(),orderItems);
    }

    public Order generateOrder(String userId, String restaurantId,List<OrderItem> orderedItems)
    {
        Order newOrder = orderService.createOrder(userId, restaurantId, orderedItems);
        this.deliverOrder(newOrder);
        return newOrder;
    }

    private void deliverOrder(Order o)
    {
        deliveryService.deliverOrder(o);
    }

    public boolean getOrderStatus(Order o)
    {
        if(deliveryService.isOrderDelivered(o))
        {
            o.orderCompleted();
            return true;
        }
        return false;
    }

    public void cancelOrder(Order o)
    {
        LocalDateTime dateAndTimeNow = LocalDateTime.now();
        if(dateAndTimeNow.minusSeconds(10).isAfter(o.getTimeStamp()))
        {
            System.out.println("Order Cant be cancelled since it is out of the cancellation time window");
        }
        else 
        {
            o.orderCancelled();
            System.out.println("Order Successfully cancelled! Reverting the deducted amount back to the source");
        }
    }





}
