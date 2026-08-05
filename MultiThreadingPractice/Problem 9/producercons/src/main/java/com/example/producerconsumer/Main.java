package com.example.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// BlockingQueue is very useful in producer consumer problems 
// Producer has queue.put() method if queue is full producer waits 
// Consumer has queue.take() method if queue is empty producer waits 
public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    try {
                        String order = "Order-" + i;
                        queue.put(order);
                        System.out.println("Produced and Put: " + order);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

       Thread consumer = new Thread(() -> {

            for(int i = 1; i <= 5; i++) {

                try {

                    String order =
                            queue.take();

                    System.out.println(
                            "Consumed: " + order);

                    Thread.sleep(4000);

                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }

        });

        producer.start();
        consumer.start();
    }
}