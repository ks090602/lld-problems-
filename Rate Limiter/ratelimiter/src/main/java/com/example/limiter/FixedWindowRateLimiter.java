package com.example.limiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.config.RateLimiterConfiguration;
import com.example.enums.RateLimiterType;
import com.example.models.FixedWindowBucket;
import com.example.models.User;

public class FixedWindowRateLimiter extends RateLimiter{
    Map<Integer,FixedWindowBucket> buckets;

    public FixedWindowRateLimiter(RateLimiterType rateLimiterType,RateLimiterConfiguration rateLimiterConfiguration)
    {
        super(rateLimiterType, rateLimiterConfiguration);
        buckets = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest(User user)
    {
        FixedWindowBucket currBucket = buckets.computeIfAbsent(user.getUserId(), id-> new FixedWindowBucket());
        
        synchronized(currBucket){
            long currWinStart = currBucket.getWindowStart();
            long currTime = System.currentTimeMillis();
            long elapsedTime = (currTime-currWinStart)/1000;
            if(elapsedTime>=rateLimiterConfiguration.getWindowInSeconds())
            {
                currBucket.setCount(1);
                currBucket.setWindowStart(currTime);
                return true;
            }
            else 
            {
                if(currBucket.getCount()<rateLimiterConfiguration.getMaxRequests())
                {
                    currBucket.incrementRequestCount();
                    return true;
                }
            } 

            return false;
        }
    }
}
