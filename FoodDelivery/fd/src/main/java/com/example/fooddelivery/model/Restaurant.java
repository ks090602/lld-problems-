package com.example.fooddelivery.model;

public class Restaurant {
    private String id;
    private String name;
    private Address address;
    private Menu menu;
    
    public Restaurant(String id, String name, Address address, Menu menu) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.menu = menu;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public String getId() {
        return id;
    }

    
}
