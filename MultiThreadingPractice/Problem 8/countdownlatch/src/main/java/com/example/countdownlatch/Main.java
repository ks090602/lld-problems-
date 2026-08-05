package com.example.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Future/CompletableFuture
//     -> Waiting for specific async computations

// CountDownLatch
//     -> Waiting for N events/tasks to finish
// This is where CountDownLatch comes into picture as this helps like a finish line where when all worker threads reach that is when the main thread continues 
// This has a counter which every worker thread will decrement ones its finished its execution
// at latch.await() main thread waits till counter is 0 and that is when main thread continues

public class Main {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);   

        executor.submit(() -> {

            System.out.println("Loading Users");
            
            try {
                Thread.sleep(2000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            
            System.out.println("Users Loaded");
            
            latch.countDown();
        });

        executor.submit(() -> {

            System.out.println("Loading Orders");
            
            try {
                Thread.sleep(2000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            
            System.out.println("Orders Loaded");

            latch.countDown();
        });
        
        executor.submit(() -> {

            System.out.println("Loading Products");
            
            try {
                Thread.sleep(2000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            
            System.out.println("Products Loaded");
            
            latch.countDown();
        });

        System.out.println(
            "Waiting for all services"
        );
        
        latch.await(); // main thread waits here till all the worker threads finish execution 
        
        System.out.println(
            "Application Started"
        );
        executor.shutdown();
    }
}