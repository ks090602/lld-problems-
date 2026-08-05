package com.example.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        RateLimiter rateLimiter = new RateLimiter();
        for(int j = 0;j<3;j++){
        executor.submit(()->{
            for(int i = 1;i<=7;i++)
            {
                System.out.println(Thread.currentThread().getName());
                System.out.println(rateLimiter.allowRequest("Kunal"));
                
            }
        });
        }
        executor.shutdown();
    }
}