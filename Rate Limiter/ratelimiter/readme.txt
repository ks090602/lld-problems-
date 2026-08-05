PREMIUM USER -> 100 requests in 60 seconds
FREE USER -> 10 requests in 60 seconds 


Ways to get time in mili seconds in java ->

long currentTime = System.currentTimeMillis();   // 12981378267621988987


Instant instant = Instant.now();
sout(instant) = 2026-06-13T10:49:02Z -> UTC timings 
long millis = instant.toEpochMilli();


LocalDateTime localDateTime = LocalDateTime.now();
sout(localDateTime) = 2026-06-13T12:31:44


