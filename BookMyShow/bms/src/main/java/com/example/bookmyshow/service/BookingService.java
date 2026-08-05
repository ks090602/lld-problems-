package com.example.bookmyshow.service;

import java.util.List;

import com.example.bookmyshow.enums.BookingStatus;
import com.example.bookmyshow.enums.PaymentStrategyType;
import com.example.bookmyshow.exception.SeatNotAvailableException;
import com.example.bookmyshow.model.Booking;
import com.example.bookmyshow.model.Seat;
import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.repository.BookingRepository;
import com.example.bookmyshow.strategy.locking.LockProvider;

public class BookingService {
    private final BookingRepository bookingRepo;
    private final LockProvider lockProvider;
    private final long TTL = 5000L;
    
    public BookingService(BookingRepository bookingRepository,LockProvider lockProvider)
    {
        this.bookingRepo = bookingRepository;
        this.lockProvider = lockProvider;
    }

    public Booking createBooking(String userId, Show show, List<String> seatIds)
    {
        for(String seatId:seatIds)
        {
            String key = show.getId() + ":" + seatId;
            if(!lockProvider.tryLock(key, userId, TTL))
            {
                throw new SeatNotAvailableException("Seat " + seatId + " is temporarily unavailable");
            } 
        }
        double extraPriceForMovie = show.getMovie().getExtraPrice();
        double totalPrice = extraPriceForMovie*seatIds.size();
        for(Seat seat : show.getScreen().getSeats())
        {
            if(seatIds.contains(seat.getID()))
            {
                totalPrice+=seat.getPrice();
            }
        }

        Booking booking = new Booking(userId, show.getId(), seatIds, BookingStatus.CREATED, null, totalPrice);
        bookingRepo.save(booking);
        System.out.println("Booking Created: " + booking.getBookingID());
        return booking; 
    }

    public void confirmBooking(Booking booking, PaymentStrategyType paymentStrategyType)
    {
        if (booking == null) {
            throw new IllegalArgumentException("Booking must not be null");
        }

        if (booking.getBookingStatus() != BookingStatus.CREATED) {
            throw new IllegalStateException("Booking cannot be confirmed in status: " + booking.getBookingStatus());
        }

        for(String seatId : booking.getSeatIDs())
        {
            String key = booking.getShowID() + ":" + seatId;
            if(lockProvider.isLockExpired(key) || !lockProvider.isLockedBy(key, booking.getUserID()))
            {
                throw new SeatNotAvailableException("Seat " + seatId + " is temporarily unavailable");
            }
        }

        booking.setPaymentType(paymentStrategyType);
        boolean paymentStatus = PaymentProcessor.payAmount(paymentStrategyType, booking.getAmount());
        if(paymentStatus){
            System.out.println("Paymenet Done");
        }
        else return;

        for(String seatId : booking.getSeatIDs())
        {
            String key = booking.getShowID() + ":" + seatId;
            lockProvider.unlock(key);
        }

        // Complete the booking confirmation and persist the updated status.
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        bookingRepo.save(booking);
        System.out.println("Booking Confirmed: " + booking.getBookingID() + " User id: " + booking.getUserID());
    }
}
