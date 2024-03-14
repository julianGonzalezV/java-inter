package org.example.concurrency.cucurrentapi;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllSample {

    public static void main(String[] args){
        ExecutorService service = Executors.newSingleThreadExecutor();

        Callable<String> serveJuice = () -> {
            Thread.sleep(1000);
           return "Serve Juice done!";
        };

        Callable<String> prepareFood = () -> {
            Thread.sleep(3000);
            return "prepare food done!";
        };

        Callable<String> organizeTable = () -> {
            Thread.sleep(400);
            return "Organize table";
        };

        try {
        List<Future<String>> restaurantService =  service
                .invokeAll(List.of(organizeTable, prepareFood, serveJuice));

        restaurantService.forEach( future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        });

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            if(service!=null) service.shutdown();
        }
    }
}
