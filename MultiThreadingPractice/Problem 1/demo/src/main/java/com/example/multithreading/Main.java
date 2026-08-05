package com.example.multithreading;

class MyTask implements Runnable {
    @Override
    public void run()
    {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Running.."); // this will be printed in both run and start case but which thread executes this that is where it differs 
        System.out.println(Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyTask(),"Kunal");
        // Whats the diff between start and run 
        t1.start(); // Kunal is starting and going to execute the run method not main 
        t1.run(); // heere since this is simply a method call for an object main thread will go and complete the execution for run method of class MyTask
        // t1.join();  // main thread waits for t1 to finish execution then only it moves ahead 
        // System.out.println("Main Thread Past calling t1");
    }
}