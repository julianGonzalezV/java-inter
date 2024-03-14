package org.example.concurrency.old;

public class MainOldWay {
    public static void main(String[] args) {
        // From java 8 Runnable is the recommended way to implement Threads
        Thread calculateAreaR = new Thread(new CalculateAverageRunnable(new double[]{1,2,3}));
        Thread calculateAreaT = new CalculateAverageThread(new double[]{4,5,6});

        System.out.println("START");
        System.out.println(Thread.currentThread().getName());

        /*BAD: Calling run does not create a new Thread and just call the run implementation of each type
        calculateAreaR.run();
        calculateAreaT.run();*/

        //T raise a new Thread call start
        calculateAreaR.start();
        calculateAreaT.start();

        System.out.println("END");
    }
}
