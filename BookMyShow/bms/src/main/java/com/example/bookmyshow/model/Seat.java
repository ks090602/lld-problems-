package com.example.bookmyshow.model;

import com.example.bookmyshow.enums.SeatType;

public abstract class Seat {
    private String id;
    private double price;
    private SeatType seatType;

    public Seat(String id,SeatType seatType,double price){
        this.seatType = seatType;
        this.id = id;
        this.price = price;
    }

    public String getID(){
        return this.id;
    } 
    public void setPrice(double newPrice)
    {
        this.price = newPrice;
    }
    public double getPrice()
    {
        return price;
    }

    public SeatType getSeatType()
    {
        return seatType;
    }


}
