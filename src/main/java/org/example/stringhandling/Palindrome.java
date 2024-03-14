package org.example.stringhandling;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Palindrome {
    /**
     * civic = true
     * amma = true
     * hello = false
     * @param inputString
     * @return
     */
    private static boolean isPalindrome(String inputString){
        String normalizedInput = inputString.toLowerCase();
        boolean result = false;
        int lastPos = normalizedInput.length()-1;
        int middlePos = normalizedInput.length()/2;
        for(int currentPos = 0; currentPos< normalizedInput.length(); currentPos++){
            result = Character.toLowerCase(normalizedInput.charAt(currentPos)) ==
                    Character.toLowerCase(normalizedInput.charAt(lastPos));
            if(!result || lastPos == middlePos){
                break;
            }
            lastPos --;
        }
        return result;
    }

    private boolean listSumGreatherThanZero(int[] A){
        int totalSum = Arrays.stream(A).reduce((x,y) -> x+y).getAsInt();
        return totalSum>0;
    }

    private static boolean isPalindromeFunc(String inputString){
        String normalizedInput = inputString.toLowerCase();
        int normalizedInputLength = normalizedInput.length();
        return IntStream.range(0, normalizedInput.length()/2).allMatch( pos ->
            normalizedInput.charAt(pos) == normalizedInput.charAt(normalizedInputLength - 1 - pos)
        );
    }


    private static void countVowelsAndConsonants(String input){
        Predicate<Character> isVowel = character ->
        {
            boolean result =  switch (character) {
                case 'a','e','i','o','u' -> {
                    System.out.println(character);
                    yield true;
                }
                default -> false;
            };
            return result;
        };

        /*long vowelsCounter = IntStream.range(0, input.length()).filter( pos -> isVowel.test(input.charAt(pos))).count();
        long consonantsCounter = IntStream.range(0, input.length()).filter( pos -> !isVowel.test(input.charAt(pos))).count();
        System.out.println("vowelsCounter ->"+vowelsCounter);
        System.out.println("consonantsCounter ->"+consonantsCounter);*/

        int vw = 0;
        int cs = 0;

        for (char ch:input.toCharArray()) {
            if(isVowel.test(ch)){
                vw ++;
            } else{
                cs ++;
            }
        }
        System.out.println("vw ->"+vw);
        System.out.println("cs ->"+cs);
    }


    public String solution(int n) {
        if(!isValidInput(n)){
            return "n is not in acceptable ranges";
        }
        // Implement your solution here


        return "";
    }

    private boolean isValidInput(int n){
        return (n > 0) && (n <= 200000);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("CIVIC"));
        System.out.println(isPalindrome("ma"));
        System.out.println(isPalindrome("amma"));
        System.out.println(isPalindrome("AB"));
        System.out.println(isPalindrome("ama"));

        System.out.println(isPalindromeFunc("maDam"));
        System.out.println(isPalindromeFunc("raceCar"));
        System.out.println(isPalindromeFunc("swims"));
        System.out.println(isPalindromeFunc("wifi"));

       countVowelsAndConsonants("raceCar");
    }



}
