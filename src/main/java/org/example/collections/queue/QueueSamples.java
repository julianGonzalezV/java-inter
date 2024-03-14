package org.example.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue: An order list where element are inserted at end but removed from the beginning
 * FIFO
 *
 * Implementations:
 *  1. LinkedList: is the standard queue implementation
 * Operations
 *
 * Usage:
 * Store the order of processes or things that need to happen
 */
public class QueueSamples {

    private static void getIntro(){
        Queue<String> queue = new LinkedList<>();
        // Order in which they turned into super-saiyan
        queue.add("Goku");
        queue.add("Vegeta");
        queue.add("Gohan");
        queue.add("Trunks");
        System.out.println(queue);

        System.out.println("queue.peek()=> "+queue.peek());//get the head without removing
        System.out.println("After PEEK() => "+queue);

        System.out.println("queue.poll()=> "+queue.poll());//get the head and remove it from queue
        System.out.println("After poll() => "+queue);

        System.out.println("Removing=> ");
        while(!queue.isEmpty()){
           String removed = queue.remove();
            System.out.println(removed);
        }
        System.out.println("After Removing=> "+ queue);
    }

    public static void main(String[] args) {
        getIntro();
    }
}
