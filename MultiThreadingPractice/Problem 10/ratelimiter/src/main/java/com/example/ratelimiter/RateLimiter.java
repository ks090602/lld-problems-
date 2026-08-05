package com.example.ratelimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    ConcurrentHashMap<String,AtomicInteger> requestCount;
    Object lock;
    public RateLimiter()
    {
        requestCount = new ConcurrentHashMap<>();
        lock = new Object();
    }

    public boolean allowRequest(String userName)
    {
        AtomicInteger count = requestCount.computeIfAbsent(userName, key -> new AtomicInteger(0));
        synchronized(lock){
            if(count.get()<5)  // this if block is not thread safe in multithreading environmentt as multiple threads can read the value of get before some thread actually changes the value leading to inconsistent results so making it synchronized is good 
            {
                count.incrementAndGet();
                return true;
            }
            return false;
        }
    }
}
