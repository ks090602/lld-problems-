package com.example.config;

public class RateLimiterConfiguration {
    private final int maxRequests;
    private final int windowInSeconds;
    
    public RateLimiterConfiguration(int maxRequests,int windowInSeconds)
    {
        this.maxRequests = maxRequests;
        this.windowInSeconds = windowInSeconds;
    }

    public int getMaxRequests() {
        return maxRequests;
    }
    public int getWindowInSeconds() {
        return windowInSeconds;
    }

}
