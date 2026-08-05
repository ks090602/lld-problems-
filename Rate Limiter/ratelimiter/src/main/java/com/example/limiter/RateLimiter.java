package com.example.limiter;

import com.example.config.RateLimiterConfiguration;
import com.example.enums.RateLimiterType;
import com.example.models.User;

public abstract class RateLimiter{
    protected RateLimiterType rateLimiterType;
    protected RateLimiterConfiguration rateLimiterConfiguration;

    public RateLimiter(RateLimiterType rateLimiterType,RateLimiterConfiguration rateLimiterConfiguration)
    {
        this.rateLimiterType = rateLimiterType;
        this.rateLimiterConfiguration = rateLimiterConfiguration;
    }

    public abstract boolean allowRequest(User user);
}