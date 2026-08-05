package com.example.factory;

import com.example.config.RateLimiterConfiguration;
import com.example.enums.RateLimiterType;
import com.example.enums.UserTier;
import com.example.limiter.RateLimiter;
import com.example.limiter.TokenBucketRateLimiter;
import com.example.limiter.FixedWindowRateLimiter;
import com.example.limiter.SlidingWindowRateLimiter;

public class RateLimiterFactory {
    public static RateLimiter getRateLimiter(UserTier userTier,RateLimiterConfiguration config) 
    {
        switch (userTier) {
            case FREE:
                return new TokenBucketRateLimiter(RateLimiterType.TOKEN_BUCKET,config);
            case PREMIUM:
                return new FixedWindowRateLimiter(RateLimiterType.FIXED_WINDOW,config);
            default:
                return new SlidingWindowRateLimiter(RateLimiterType.SLIDING_WINDOW_COUNTER,config);
        }
    }
}
