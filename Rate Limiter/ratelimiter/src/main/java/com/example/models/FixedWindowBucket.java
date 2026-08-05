package com.example.models;

public class FixedWindowBucket {
    private int count;
    private long windowStart;

    public FixedWindowBucket() {
        this.count = 0;
        this.windowStart = System.currentTimeMillis();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getWindowStart() {
        return windowStart;
    }

    public void setWindowStart(long windowStart) {
        this.windowStart = windowStart;
    }

    public void incrementRequestCount()
    {
        count++;
    }
}
