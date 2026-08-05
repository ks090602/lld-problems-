package com.example.multithread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Future is created to get the value of an asynchronous call later in the code meanwhile the main thread continues its execution
// Future stores a placeholder for a value that will become available later

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*
        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println("Main thread before work thread");
        Future<Integer> future = executor.submit(()->{
            System.out.println("Calculating someting, Thread name is: " + Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            return 5000;
        });
        System.out.println("Main Thread after Work Thread");
        Integer salary = future.get(); // main thread waits till the result comes 
        System.out.println("Salary is: " + salary);
        executor.shutdown();
        */
        //     What happens without future.get?
        //     Worker thread still computes.
        // But now:
        // 5000
        // is never collected.
        // The result is lost.


        // Completable Future
        // Say we need to fetch data from a server which takes 2 seconds each rather than a synchronized call we can use completableFuture and fetch the data in 2 seconds only 
        // supplyAsync() submits work to a thread pool -> ForkJoinPool.commonPool
        // main thread waits at get line
        // Immediately after creation a placeholder is stored in CompletableFuture<String>

        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(
            Thread.currentThread().getName()
            );
            return "User Data";
        });

        CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(
            Thread.currentThread().getName()
            );
            return "Order Data";
        }).thenApply((order)->{
            System.out.println("Converting To UpperCase");
            return order.toUpperCase();
        });

        CompletableFuture<String> paymentFuture = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(
            Thread.currentThread().getName()
            );
            return "Payment Data";
        }); 

        System.out.println("Main Thread after Completable future lines written");

        String user = userFuture.get();
        String order = orderFuture.get();
        String payment = paymentFuture.get();
        
        System.out.println("Main thread after get lines");

        System.out.println(user);
        System.out.println(order);
        System.out.println(payment);
    }
}