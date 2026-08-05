package com.example.bookmyshow.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.bookmyshow.enums.BookingStatus;
import com.example.bookmyshow.enums.PaymentStrategyType;

public class Booking {
    private static final AtomicInteger autoID = new AtomicInteger(0);
    private final int bookingID;
    private final String userID;
    private final int showID;
    private final List<String> seatIDs;
    private BookingStatus bookingStatus;
    private PaymentStrategyType paymentType;
    private double amount;

    public Booking(String userID, int showID, List<String> seatIds, BookingStatus bookingStatus, PaymentStrategyType paymentType, double amount)
    {
        this.bookingID = autoID.incrementAndGet();
        this.userID = userID;
        this.showID = showID;
        this.seatIDs = seatIds;
        this.bookingStatus = bookingStatus;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public int getBookingID() {
        return bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public int getShowID() {
        return showID;
    }

    public List<String> getSeatIDs() {
        return seatIDs;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public PaymentStrategyType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentStrategyType paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
