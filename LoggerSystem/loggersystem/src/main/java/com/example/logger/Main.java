package com.example.logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.logger.enums.LogLevel;
import com.example.logger.service.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        // logger.log(LogLevel.INFO, "Hi Info");
        // logger.info("Hi Again Info");
        Thread t1 = new Thread(()->{
            logger.log(LogLevel.WARN, "Harsh"); 
        });
        Thread t2 = new Thread(()->{
            logger.log(LogLevel.WARN, "Harsh"); 
        });
        Thread t3 = new Thread(()->{
            logger.error("Annapurna"); 
        });
        Thread t4 = new Thread(()->{
            logger.info("Kailash"); 
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        ExecutorService executor = Executors.newFixedThreadPool(100);
        for(int i = 0;i<1000;i++)
        {
            int itCount = i;
            executor.submit(()->{
                logger.error("Kunal Cold " + itCount + " ");
            });
        }
        executor.shutdown();
    }
}