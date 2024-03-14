package org.example.concurrency.old;

import java.util.Arrays;

public class CalculateAverageRunnable implements Runnable{
    private double[] scores;

    /**
     * Notice the constructor is the way of passing information to the runnable object
     * @param scores
     */
    public CalculateAverageRunnable(double[] scores){
        this.scores = scores;
    }

    @Override
    public void run(){
        System.out.println("CalculateAverageRunnable");
        System.out.println(Thread.currentThread().getName());
        Arrays.stream(scores).forEach(System.out::println);
    }
}
