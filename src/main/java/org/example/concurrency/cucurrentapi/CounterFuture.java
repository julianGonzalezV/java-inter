package org.example.concurrency.cucurrentapi;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Setting up a Future by using Runnable interface
 */
public class CounterFuture {
    private static int counter = 0;

    public static void main(String[] args) {
        ExecutorService service =  Executors.newSingleThreadExecutor();
        Future counterFutureResult = service.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0 ; i <500; i++){
                CounterFuture.counter++;
            }
        });

        try {
            counterFutureResult.get(10, TimeUnit.SECONDS);// Retrieves the result of a task
            System.out.println("isDone -> "+counterFutureResult.isDone());// true if the task was completed, threw an exception, or was cancelled
            System.out.println("isCancelled -> "+counterFutureResult.isCancelled()); // true if the task was cancelled before it completed normally

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            if(service != null) service.shutdown();
        }
        System.out.println("Reached!");
    }
}
