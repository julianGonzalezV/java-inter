package org.example.algo;

import java.util.Arrays;

public class Coins {

    private static int PARTICIPANTS = 3;

    /**
     * https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
     * @param piles
     * @return
     */
    public static int maxCoins(int[] piles) {
        if(piles.length % PARTICIPANTS != 0){
            return 0;
        }
        Arrays.sort(piles);
        int[] pilesNormalized = Arrays.copyOfRange(piles,piles.length/PARTICIPANTS,piles.length);

        int sumOfSecond = 0;

        for(int i =0; i < pilesNormalized.length; i+=2){
            sumOfSecond += pilesNormalized[i];
        }

        return sumOfSecond;
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2,4,1,2,7,8}));
        System.out.println(maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));

    }
}

