package com.example.service;

import java.util.HashMap;
import java.util.Map;

import com.example.config.RateLimiterConfiguration;
import com.example.enums.UserTier;
import com.example.factory.RateLimiterFactory;
import com.example.limiter.RateLimiter;
import com.example.models.User;

// PREMIUM USER -> 100 requests in 60 seconds
// FREE USER -> 10 requests in 60 seconds 
public class RateLimiterService {
    private final Map<UserTier,RateLimiter> rateLimiters;

    public RateLimiterService()
    {
        rateLimiters = new HashMap<>();
        rateLimiters.put(UserTier.FREE,RateLimiterFactory.getRateLimiter(UserTier.FREE, new RateLimiterConfiguration(10,60)));
        rateLimiters.put(UserTier.PREMIUM,RateLimiterFactory.getRateLimiter(UserTier.PREMIUM, new RateLimiterConfiguration(100,60)));
    }

    public boolean allowRequest(User user)
    {
        RateLimiter limiter = rateLimiters.get(user.getUserTier());
        if(limiter==null)
        {
            throw new IllegalArgumentException("No limiter configured for " + user.getUserTier());
        }
        return limiter.allowRequest(user);
    }

}
