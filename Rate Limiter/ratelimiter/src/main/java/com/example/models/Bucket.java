package com.example.models;

public class Bucket {
    private int tokens;
    private long lastRequestTime;

    public Bucket(int tokens)
    {
        this.tokens = tokens;
        lastRequestTime = System.currentTimeMillis();
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public long getLastRequestTime() {
        return lastRequestTime;
    }

    public void setLastRequestTime(long lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
    }
}
