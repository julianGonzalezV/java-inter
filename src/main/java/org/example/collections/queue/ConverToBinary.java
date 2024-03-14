package org.example.collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConverToBinary {/**
 * My solution
 * @param n
 * @return
 * O(n)
 */
private static String convertToBinary(int n){
    String result = "";
    Stack<Integer> binaries = new Stack();

    while (n>0){
        int mod = n%2;
        binaries.add(mod);
        n= n/2;
    }

    while (!binaries.isEmpty()){
        result+= binaries.pop();
    }
    return result;
}

    /**
     * My solution
     * @param n
     * O(n2/2): Given this performance so generateBinariesV3 is better
     */
    private static void generateBinaries(int n){
        System.out.println("generateBinaries My version");
        if(n<=0){
            System.out.println("Not a valid number");
            return;
        }

        for(int i = 1; i<=n; i++){
            System.out.println(convertToBinary(i));
        }
        System.out.println();
    }

    /**
     * intToBinary
     * input:  n
     * Output: binary number of n
     * Sample: intToBinary(4) should return 100
     * Restriction: using Integer.toBinaryString(i) is not allowed
     * @param n
     */
    private static void generateBinariesV2(int n){
        System.out.println("generateBinariesV2");
        if(n<=0){
            System.out.println("Not a valid number");
            return;
        }

        for(int i = 1; i<=n; i++){
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println();
    }

    /**
     * From linkedinLearning
     * Approach: By using a queue
     * @param n
     */
    private static void generateBinariesV3(int n){
        System.out.println("generateBinariesV3");
        if(n<=0){
            System.out.println("Not a valid number");
            return;
        }

        Queue<Integer> binariesQueue = new LinkedList();
        binariesQueue.add(1);

        for(int i = 1; i<=n; i++){
            int current = binariesQueue.remove();
            System.out.println(current);

            binariesQueue.add(current*10);
            binariesQueue.add((current*10) +1);
        }
    }


    public static void main(String[] args) {
        convertToBinary(4);
        generateBinaries(4);
        generateBinariesV2(4);
        generateBinariesV3(4);
    }

}
