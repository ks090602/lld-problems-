package com.example.bookmyshow.model;

import com.example.bookmyshow.enums.SeatType;

public class RegularSeat extends Seat{
    public RegularSeat(String id,double price){
        super(id,SeatType.RECLINER,price);
    }
}
