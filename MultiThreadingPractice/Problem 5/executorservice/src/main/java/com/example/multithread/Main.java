package com.example.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// class MyTask implements Runnable{
//     @Override
//     public void run(){
//         System.out.println(Thread.currentThread().getName() + "executing Task ");
//         try{
//             Thread.sleep(2000);
//         }catch(InterruptedException e)
//         {
//             e.printStackTrace();
//         }
//         System.out.println(Thread.currentThread().getName() + "completed Task ");
//     }
// }


// Java creates 3 threads and those 3 threads executes 5 tasks meanwhile say x tasks are getting executed the remaining stay in work queue 
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i = 0;i<5;i++)
        {
            int taskId = i;
            executor.submit(()->{
                System.out.println(Thread.currentThread().getName() + "executing Task " + taskId);
                try{
                    Thread.sleep(2000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "completed Task " + taskId);
            });
        }
        executor.shutdown();
    }
}