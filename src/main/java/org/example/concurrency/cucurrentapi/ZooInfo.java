package org.example.concurrency.cucurrentapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ZooInfo {
    public static void main(String[] args) {
        ExecutorService service = null;
        Runnable task1 = () -> {
            System.out.println("Zoo task 1 with thread: "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable task2 = () -> {
            System.out.println("task2-> with thread: "+Thread.currentThread().getName());
            IntStream.range(0,3).forEach(item -> System.out.println("record" + item));
        };

        try {
            // With SingleThreadExecutor executor, results are executed sequentially
            service = Executors.newSingleThreadExecutor();
            System.out.println("START");
            service.execute(task1);
            /**
             * EXECUTE() is a "fire‐and‐forget" method there is other one call submit()
             * that returns a Future that can be checked wether the task's been completed.
             *
             * Use SUBMIT() over EXECUTE()
             */
            service.execute(task2);
            service.execute(task1);
            System.out.println("END");
        }finally {
            if(service != null) service.shutdown();
            // If all threads are completed then next two lines are true. On the other hand if
            // there are pending threads to complete then just service.isShutdown() is true and
            // service.isTerminated() is false
            service.isShutdown();
            service.isTerminated();
        }
    }
}
