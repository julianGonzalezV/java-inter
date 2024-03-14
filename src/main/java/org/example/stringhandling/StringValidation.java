package org.example.stringhandling;

import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringValidation {
    private static boolean isValidPassword(String inputPw){
        return inputPw.chars().anyMatch( Character::isUpperCase) &&
                inputPw.chars().anyMatch( Character::isLowerCase) &&
                inputPw.chars().anyMatch( Character::isDigit);
    }

    private static boolean isUpperCase(String input){
        return input.chars().allMatch(Character::isUpperCase);
    }

    private static String normalizeToJustLowerCaseLetter(String input){
        return input.toLowerCase().trim().replace(",","")
                .chars()
                .filter(Character::isLetter)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    private static String intStreamToString(int[] values) {
        return IntStream.of(values)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static boolean isAtEvenIndex(String input, char charToLook){
        if(Objects.isNull(input) || input.isEmpty()){
            return false;
        }

        for(int i = 0; i< input.length()/2 ; i= i+2){
            if(input.charAt(i) == charToLook){
                return true;
            }
        }
        return false;
    }

    private static String reverse(String input){
        if(input == null || input.isEmpty()){
            return input;
        }

        StringBuilder result = new StringBuilder();
        for(int i= input.length()-1 ; i>=0 ; i-- ){
            result.append(input.charAt(i));
        }
        return result.toString();
    }

    /**
     * bUILT-IN TOOL
     * @param input
     * @return
     */
    private static String reverse2(String input){
        if(input == null || input.isEmpty()){
            return input;
        }
        StringBuilder result = new StringBuilder(input);
        return result.reverse().toString();
    }

    /**
     * Reverse each word in a sentences
     * hola como estas
     * estas como hola
     * @param sentence
     * @return
     */
    private static String reverseSentence(String sentence){
        if(sentence==null || sentence.isEmpty()){
            return sentence;
        }

        String[]  words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i= words.length - 1 ; i>=0; i--){
            result.append(words[i]);
            result.append(" ");
        }
        return result.toString();
    }

    public String solution(int n) {
        if(!isValidInput(n)){
            return "n is not in acceptable ranges";
        }
        // Implement your solution here
        Random randomLetter = new Random();
        StringBuilder result = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            char c = (char)(randomLetter.nextInt(26) + 'a');
            result.append(c);
        }
        return result.toString();
    }

    private boolean isValidInput(int n){
        return (n > 0) && (n <= 200000);
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("J4g"));
        System.out.println(isValidPassword("Hello"));
        System.out.println(isValidPassword("Hell0"));
        System.out.println(isValidPassword("hola"));

        System.out.println("ALL UPPERCASE");
        System.out.println(isUpperCase("abc"));
        System.out.println(isUpperCase("aBc"));
        System.out.println(isUpperCase("ABC"));
        System.out.println(isUpperCase("A4C"));

        System.out.println("GET NORMALIZE");
        System.out.println(normalizeToJustLowerCaseLetter("A4C"));

        System.out.println("intStreamToString");
        System.out.println(intStreamToString(new int[]{1,2,3,4}));

        System.out.println("EVEN INDEX");
        System.out.println(isAtEvenIndex("beauty", 'a'));
        System.out.println(isAtEvenIndex("beauty", 'b'));
        System.out.println(isAtEvenIndex("beauty", 'u'));
        System.out.println(isAtEvenIndex("beautyi", 'i'));

        System.out.println("REVERSE");
        System.out.println(reverse("J4g"));
        System.out.println(reverse("THIS IS A REAL STORY"));
        System.out.println(reverse2("THIS IS A REAL STORY 2"));

        System.out.println("REVERSE WORDS IN SENTENCES");
        System.out.println(reverseSentence("hola como ESTAS"));
    }
}
