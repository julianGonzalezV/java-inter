package org.example.collections.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayMerging {
    public static int[]  merge(int[] arr1, int[] arr2, int m , int n){
        int arr1Length = arr1.length;
        int arr1Idx = m;
        for(int i=0; i<n; i++){
            arr1[arr1Idx+i] = arr2[i];
        }
        return arr1;
    }

    public static int[]  mergeAndSort(int[] arr1, int[] arr2, int m , int n){
        for(int i=0; i<arr1.length; i++){
            if(i<n && arr2[i]< arr1[i]){
                int tempAux = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = tempAux;
            }
            if(i>m-1){
                arr1[i] = arr2[i-n];
            }
        }
        return arr1;
    }

    /**
     * {7,2,9,0,0,0}, new int[]{1,2,3}
     * @param arr1
     * @param arr2
     * @param m
     * @param n
     * @return
     */
    public static int[]  duplicatedMergeAndSort(int[] arr1, int[] arr2, int m , int n){
        int repeatedValue = 0;
        for(int i=0; i<arr1.length; i++){
            if(repeatedValue>0){
                arr1[i] = repeatedValue;
                repeatedValue = 0;
                continue;
            }
            if(i<n && arr2[i]< arr1[i]){
                int tempAux = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = tempAux;
            }

            if(i<n && arr2[i]==arr1[i]){
                repeatedValue = arr2[i];
                continue;
            }

            if(i>m-1){
                arr1[i] = arr2[i-n];
            }
        }

        return arr1;
    }

    public static void printArray(int[] arr){
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void main(String[] args) {
        printArray(merge(new int[]{7,8,9,0,0,0}, new int[]{1,2,3}, 3, 3));
        System.out.println();

        printArray(mergeAndSort(new int[]{7,8,9,0,0,0}, new int[]{1,2,3}, 3, 3));
        System.out.println();

        /**
         * output: 123729
         * As you can see the item value as 2(previous to 9) is not well located so the answer should be  122379
         */
        printArray(mergeAndSort(new int[]{7,2,9,0,0,0}, new int[]{1,2,3}, 3, 3));
        System.out.println();

        printArray(duplicatedMergeAndSort(new int[]{7,2,9,0,0,0}, new int[]{1,2,3}, 3, 3));
        System.out.println();

    }
}
