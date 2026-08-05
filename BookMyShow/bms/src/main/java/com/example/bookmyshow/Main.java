package com.example.bookmyshow;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.example.bookmyshow.enums.PaymentStrategyType;
import com.example.bookmyshow.model.Booking;
import com.example.bookmyshow.model.Movie;
import com.example.bookmyshow.model.ReclinerSeat;
import com.example.bookmyshow.model.RegularSeat;
import com.example.bookmyshow.model.Screen;
import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.Theatre;
import com.example.bookmyshow.repository.BookingRepository;
import com.example.bookmyshow.repository.MovieRepository;
import com.example.bookmyshow.repository.ShowRepository;
import com.example.bookmyshow.repository.TheatreRepository;
import com.example.bookmyshow.service.BookingService;
import com.example.bookmyshow.service.MovieService;
import com.example.bookmyshow.service.ShowService;
import com.example.bookmyshow.service.TheatreService;
import com.example.bookmyshow.strategy.locking.InMemoryLockProvider;
import com.example.bookmyshow.strategy.locking.LockProvider;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        TheatreRepository theatreRepository = new TheatreRepository();
        MovieRepository movieRepository = new MovieRepository();
        ShowRepository showRepository = new ShowRepository();
        BookingRepository bookingRepository = new BookingRepository();
        
        LockProvider lockProvider = new InMemoryLockProvider();
        
        TheatreService theatreService = new TheatreService(theatreRepository);
        MovieService movieService = new MovieService(movieRepository);
        ShowService showService = new ShowService(showRepository);
        BookingService bookingService = new BookingService(bookingRepository,lockProvider);

        Theatre pvr = theatreService.createTheatre("PVR Vegas");
        Screen screen1 = new Screen(); 
        screen1.addSeat(new RegularSeat("A-1", 150));
        screen1.addSeat(new RegularSeat("A-2", 150));
        screen1.addSeat(new RegularSeat("A-3", 150));
        screen1.addSeat(new RegularSeat("A-4", 150));
        screen1.addSeat(new RegularSeat("A-5", 150));
        screen1.addSeat(new RegularSeat("A-6", 150));
        screen1.addSeat(new RegularSeat("A-7", 150));
        screen1.addSeat(new RegularSeat("A-8", 150));
        screen1.addSeat(new ReclinerSeat("B-1", 450));
        screen1.addSeat(new ReclinerSeat("B-2", 450));
        screen1.addSeat(new ReclinerSeat("B-3", 450));


        Movie interstellar = movieService.createMovie("Interstellar", 120, 200);
        LocalDateTime start = LocalDateTime.of(2026, 7, 23, 18, 30);
        LocalDateTime end = LocalDateTime.of(2026, 7, 23, 21, 0);
        Show show1 = showService.createShow(interstellar, pvr, screen1, start, end);

        // First Demo 
        System.out.println("==== Demo 1: Search Shows for a Movie ====");
        List<Show> shows = showService.getShowsByMovieTitle(interstellar.getTitle());
        for(Show show : shows)
        {
            System.out.println("Show is available at " + show.getTheatre().getName() + " with show starting at " + show.getStart() + " and ending at " + show.getEnd());
        }


        // Second Demo 
        System.out.println("==== Demo 2: 1 user book seats ====");
        Booking booking1 = bookingService.createBooking("Kunal", show1, List.of("A-1","A-2"));
        bookingService.confirmBooking(booking1, PaymentStrategyType.CARD);

        // Third Demo
        System.out.println("==== Demo 3: 2 user book overlapping seats concurrently ====");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(()->{
            try{
                Booking booking2 = bookingService.createBooking("Harsh", show1, List.of("A-5","A-6"));
                Thread.sleep(1000);
                bookingService.confirmBooking(booking2, PaymentStrategyType.CARD);
            }catch(Exception e)
            {
                System.out.println("Harsh Failed to book seats " + e.getMessage());
            }
        });

        executor.submit(()->{
            try{
                Booking booking3 = bookingService.createBooking("Anjali", show1, List.of("A-6","A-7"));
                Thread.sleep(1000);
                bookingService.confirmBooking(booking3, PaymentStrategyType.UPI);
            }catch(Exception e)
            {
                System.out.println("Anjali Failed to book seats " + e.getMessage());
            }
        });


        executor.shutdown();
        
        try{
            if(!executor.awaitTermination(5, TimeUnit.SECONDS))
            {
                System.out.println("Background Threads are likely deadlocked. Forcing Shutdown");
                executor.shutdownNow();
            }
        }catch(InterruptedException e)
        {
            executor.shutdownNow();
        }

        
        // Fourth Demo 
        System.out.println("==== Demo 4: Booking expires after TTL ====");
        Booking b1 = bookingService.createBooking("Modi", show1, List.of("B-1","B-2"));
        System.out.println("Modi Created booking but did not pay");
        
        Thread.sleep(7000);
        
        System.out.println("Rahul trying to book same seats after TTL");
        Booking b2 = bookingService.createBooking("Rahul", show1, List.of("B-1","B-2"));
        System.out.println("Rahul Seats Booked");

        try {
            bookingService.confirmBooking(b1, PaymentStrategyType.CARD);
            System.out.println("Modi Payment Done");
        } catch (Exception e) {
            System.out.println("Modi payment failed: " + e.getMessage());
        }

        try {
            bookingService.confirmBooking(b2, PaymentStrategyType.CARD);
            System.out.println("Rahul payment Done");
        } catch (Exception e) {
            System.out.println("Rahul payment failed: " + e.getMessage());
        }

        

        
    }
}