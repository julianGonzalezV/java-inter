package org.example.concurrency.cucurrentapi;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAnySample {

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
            return "Organize table";
        };

        try {
        String restaurantService =  service
                .invokeAny(List.of(serveJuice,organizeTable,prepareFood));
            System.out.println(restaurantService);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }finally {
            if(service!=null) service.shutdown();
        }
    }
}
