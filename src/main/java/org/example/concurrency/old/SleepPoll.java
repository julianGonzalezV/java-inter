package org.example.concurrency.old;

public class SleepPoll {
    private static int counter = 0;

    /**
     * If you comment Thread.sleep you cound end up with next console output:
     *
     * Not reached yet
     * Not reached yet
     * Not reached yet
     * Not reached yet
     * Not reached yet
     * Reached => 500
     *
     * instead of the expected one:
     * Not reached yet
     * Reached => 500
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
           for(int i = 0; i<500;i++){
               SleepPoll.counter++;
           }
        }).start();

        while (SleepPoll.counter < 100){
            System.out.println("Not reached yet");
            Thread.sleep(1000); // this prevents a possibly infinite loop
            // BUT it doesn't guarantee when the loop will terminate
            // Eg Other thread with higher priority being executed or
            // Two Threads waiting for the value for private static int counter
        }
        System.out.println("Reached => "+counter);
    }
}
