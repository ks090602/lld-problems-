package com.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.enums.UserTier;
import com.example.models.User;
import com.example.service.RateLimiterService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to Rate Limiter!");

        RateLimiterService rateLimiterService = new RateLimiterService();
        User user1 = new User("Kunal",UserTier.FREE);
        User user2 = new User("Supriya",UserTier.PREMIUM);
        
        // for(int i = 1;i<16;i++)
        // {
        //     System.out.println("kunal requested API -> " + i + " -> " + rateLimiterService.allowRequest(user1));
        //     System.out.println("\n");
        //     try {
        //         Thread.sleep(10);
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     }
        // }

        // for(int i = 1;i<120;i++)
        // {
        //     System.out.println("Supriya requested API -> " + i + " -> " + rateLimiterService.allowRequest(user2));
        //     System.out.println("\n");
        //     try{
        //         Thread.sleep(10);
        //     }catch(Exception e){
        //         e.getMessage();
        //     }
        // }

        // checkConcurrency(rateLimiterService,user1);
        checkConcurrency(rateLimiterService,user2);
    }

    private static void checkConcurrency(RateLimiterService rateLimiterService,User user) throws InterruptedException
    {
        int threads = 220;

        ExecutorService executor = Executors.newFixedThreadPool(threads);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threads);
        CountDownLatch CountDownLatch = new CountDownLatch(threads);

        AtomicInteger countAllowed = new AtomicInteger();
        for(int i = 1;i<=threads;i++)
        {
            final int reqNum = i;
            executor.submit(()->{
                try{
                    // all threads wait here until barrier is full
                    cyclicBarrier.await();
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    CountDownLatch.countDown();
                }
                
                boolean allowed = rateLimiterService.allowRequest(user);
                if(allowed) countAllowed.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+ "| Request Number " + reqNum + " for User " + user.getUserName() + " " + (allowed?"ALLOWED":"BLOCKED"));
                System.out.println("\n");
            });
        }
        CountDownLatch.await(); // wait for all threads to finish
        executor.shutdown();
        System.out.println("Total Allowed Requests = " + countAllowed);
    }
}