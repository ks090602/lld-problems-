package com.example.bookmyshow.strategy.locking;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InMemoryLockProvider implements LockProvider{
    private static class Lock{
        private final String userID;
        private final long expiryTime;

        public Lock(String userID, long expiryTime)
        {
            this.userID = userID;
            this.expiryTime = expiryTime;
        }

        public String getUserID(){
            return userID;
        }

        public long getExpiryTime(){
            return expiryTime;
        }
    }

    private final ConcurrentMap<String, Lock> locks = new ConcurrentHashMap<>();
    private final ScheduledExecutorService cleanupTimer;

    public InMemoryLockProvider()
    {
        this.cleanupTimer = Executors.newSingleThreadScheduledExecutor();
        this.cleanupTimer.scheduleAtFixedRate(this::cleanUpExpiredLocks, 1, 1, TimeUnit.MINUTES);
    }

    private void cleanUpExpiredLocks()
    {
        long now = System.currentTimeMillis();
        locks.entrySet().removeIf(entry -> entry.getValue().getExpiryTime() < now);
    }

    @Override
    public boolean tryLock(String key, String userID, long ttlMs){
        long now = System.currentTimeMillis();
        Lock lock = new Lock(userID, now+ttlMs);

        return locks.compute(key,(k,l)->(l==null || l.getExpiryTime()<=now)?lock:l)==lock;
    }

    @Override
    public void unlock(String key){
        locks.remove(key);
    }

    @Override
    public boolean isLockExpired(String key){
        Lock lock = locks.get(key);
        // return true if the lock doesnt exists OR if it's time has run out  
        return lock==null || lock.getExpiryTime()<System.currentTimeMillis();
    }

    @Override
    public boolean isLockedBy(String key, String userID) {
        Lock lock = locks.get(key);
        // Use the local 'lock' variable you already pulled!
        return lock != null && 
               lock.getUserID().equals(userID) && 
               lock.getExpiryTime() >= System.currentTimeMillis();
    }
}
