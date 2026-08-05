package com.example.bookmyshow.strategy.locking;

public interface LockProvider {
    boolean tryLock(String key, String userID, long ttlMs);
    void unlock(String key);
    boolean isLockExpired(String key);
    boolean isLockedBy(String key, String userID);
}
