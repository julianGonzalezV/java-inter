package org.example.collections.arrays;

import java.util.Arrays;

public class Reverse {

    private static int[] reverse(int[] inputArr){
        int[] reversedArray = new int[inputArr.length];
        int index = 0;
        for(int i=inputArr.length-1; i>=0; i--){
            reversedArray[index] = inputArr[i];
            index++;
        }
        return reversedArray;
    }

    private static int[] reverse2(int[] inputArr){
        int[] reversedArray = new int[inputArr.length];
        for(int i=0; i<inputArr.length; i++){
            reversedArray[i] = inputArr[inputArr.length-i-1];
        }
        return reversedArray;
    }

    static void printArray(int[] inputArr){
        Arrays.stream(inputArr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        printArray(reverse(new int[]{1,2,3}));

        System.out.println("Reverse2::");
        printArray(reverse2(new int[]{1,2,3}));
    }
}
