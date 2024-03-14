package org.example.concurrency.old;

import java.util.Arrays;

public class CalculateAverageThread extends Thread{
    private double[] scores;

    /**
     * Notice the constructor is the way of passing information to the runnable object
     * @param scores
     */
    public CalculateAverageThread(double[] scores){
        this.scores = scores;
    }

    @Override
    public void run(){
        System.out.println("CalculateAverageThread");
        System.out.println(Thread.currentThread().getName());
        Arrays.stream(scores).forEach(System.out::println);
    }
}
