package com.example.multithread;

import java.util.concurrent.atomic.AtomicInteger;

class Counter{
    private AtomicInteger count = new AtomicInteger(0);

    public void increment()
    {
        count.incrementAndGet();  
    }
    public int getCount()
    {
        return count.get();
    }
}



public class Main {
    public static void main(String[] args) throws InterruptedException{
        Counter counter = new Counter();
        
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for(int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });


        // Scenario 1 -> Not synchronized method

        // t1.start();
        // t2.start();
        
        // t1.join();
        // t2.join();

        // System.out.println(counter.getCount()); // since both threads execute concurrently so the final value is not guranteed as this code is not thread-safe or synchronized hence the value will be somwhere less than 200000


        // Scenario 2 -> When The method is synchronized 
        // t1.start();
        // t2.start();

        // t1.join();
        // t2.join();

        // System.out.println(counter.getCount()); // value = 200000


        // Scenario 3 -> count made as AtomicInteger 
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount()); // Since AtomicInteger has atomic methods that work on compare and swap thus its another modern way of thread synhronization 
        // for check then act situtation you might need external synchronizatoin as well
        // if(count.get() < 1000) {
        //     count.incrementAndGet();
        // }


        
    }
}