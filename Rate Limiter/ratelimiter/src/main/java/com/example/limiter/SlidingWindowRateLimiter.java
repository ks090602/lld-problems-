package com.example.limiter;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import com.example.config.RateLimiterConfiguration;
import com.example.enums.RateLimiterType;
import com.example.models.User;

public class SlidingWindowRateLimiter extends RateLimiter{
    private Map<Integer,Queue<Long>> slidingWindowMap;
    public SlidingWindowRateLimiter(RateLimiterType rateLimiterType,RateLimiterConfiguration rateLimiterConfiguration)
    {
        super(rateLimiterType, rateLimiterConfiguration);
        slidingWindowMap = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(User user)
    {   
        Queue<Long> currQueue = slidingWindowMap.computeIfAbsent(user.getUserId() ,id-> new ArrayDeque<Long>());
        long now = System.currentTimeMillis();

        synchronized(currQueue){
            while(!currQueue.isEmpty() && (((now-currQueue.peek())/1000)>rateLimiterConfiguration.getWindowInSeconds()))
            {
                currQueue.poll();
            }

            if(currQueue.size()<rateLimiterConfiguration.getMaxRequests())
            {
                currQueue.add(now);
                return true;
            }

            return false;
        }
    }

}
