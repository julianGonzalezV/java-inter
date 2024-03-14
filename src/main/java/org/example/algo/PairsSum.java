package org.example.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairsSum {

    static class Pair{
        private int val1;
        private int val2;

        public Pair(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val1=" + val1 +
                    ", val2=" + val2 +
                    '}';
        }
    }

    private static Set<Integer> getSumPairs(Integer[] input, int n){
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> numbersToMap = toMap(input);

        for (Integer number : input ) { // O(n)
            if(numbersToMap.containsKey(n-number)){ //O(1)
                result.add(number);
                result.add(n-number);
            }
        }
        return  result;
    }

    private static Map<Integer, Integer> toMap(Integer[] input){
        Map<Integer, Integer> result = new HashMap<>();
        for (Integer number : input
             ) {
            result.put(number, number);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getSumPairs(new Integer[]{2,4,6,1,7,3}, 5));
        System.out.println(getSumPairs(new Integer[]{2,4,6,1,7,3,9}, 7));
    }
}
