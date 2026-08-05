package com.example.limiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.config.RateLimiterConfiguration;
import com.example.enums.RateLimiterType;
import com.example.models.Bucket;
import com.example.models.User;

public class TokenBucketRateLimiter extends RateLimiter{
    // The below two maps was the old idea when I didnt use Bucket
    // Map<Integer,Integer> bucket;
    // Map<Integer,Long> lastRquestTime;

    // this map stores userID and corresponding Bucket object for that user, Inside bucket object we can get tokens count and last Request time in miliseconds
    Map<Integer,Bucket> buckets; 
    
    public TokenBucketRateLimiter(RateLimiterType rateLimiterType,RateLimiterConfiguration rateLimiterConfiguration)
    {
        super(rateLimiterType, rateLimiterConfiguration);
        buckets = new ConcurrentHashMap<>();
    }


    @Override 
    public boolean allowRequest(User user)
    {
        Bucket bucketForCurrUser = buckets.computeIfAbsent(user.getUserId(),id -> new Bucket(rateLimiterConfiguration.getMaxRequests()));
        
        synchronized(bucketForCurrUser){
            // READ STATEMENTS 
            long lastRequestTime = bucketForCurrUser.getLastRequestTime();
            long currTime = System.currentTimeMillis();
            
            // CALCULATE STATEMENTS
            long elapsedTime = currTime - lastRequestTime;
            double refillRate = (double) rateLimiterConfiguration.getMaxRequests()/ rateLimiterConfiguration.getWindowInSeconds();
            int refillTokens = (int) (elapsedTime/1000 * refillRate);
            int currentTokens = bucketForCurrUser.getTokens();
            int newTokenCount = Math.min(refillTokens+currentTokens,    rateLimiterConfiguration.getMaxRequests());
            
            // WRITE STATEMENTS 
            if(newTokenCount>0)
            {
                bucketForCurrUser.setTokens(newTokenCount-1);
                bucketForCurrUser.setLastRequestTime(System.currentTimeMillis());
                return true;
            }
            return false;
        }
    }

}