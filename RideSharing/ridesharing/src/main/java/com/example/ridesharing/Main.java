package com.example.ridesharing;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for(int i = 0;i<100000;i++)
            {
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(()->{
            for(int i = 0;i<100000;i++)
            {
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(()->{
            for(int i = 0;i<100000;i++)
            {
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        Thread thread4 = new Thread(()->{
            for(int i = 0;i<100000;i++)
            {
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}