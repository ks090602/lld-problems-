package com.example.bookmyshow.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.bookmyshow.model.Booking;

public class BookingRepository {
    private Map<Integer, Booking> map = new HashMap<>();

    public void save(Booking booking)
    {
        map.put(booking.getBookingID(), booking);
    }
    public Booking get(int bookingID)
    {
        return map.get(bookingID);
    }
}
