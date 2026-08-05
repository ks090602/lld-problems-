package com.example.bookmyshow.model;

import com.example.bookmyshow.enums.SeatType;

public class ReclinerSeat extends Seat{
    public ReclinerSeat(String id,double price){
        super(id,SeatType.RECLINER,price);
    }
}
