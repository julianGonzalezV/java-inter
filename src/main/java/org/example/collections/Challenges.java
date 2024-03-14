package org.example.collections;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Challenges {

    /**
     * My solution
     * @param input
     * @return
     */
    private static String mostRepeatedWord(String input){

        String inputToUpperCase = input.toUpperCase();
        List<String> words = Arrays.asList(inputToUpperCase.split("[,\s]"));

        Map<String, Integer> wordToRepetition = new LinkedHashMap<>();
        words.forEach( word ->{
            if(!wordToRepetition.containsKey(word)){
                wordToRepetition.put(word, 1);
            }else{
                wordToRepetition.compute(word, (k,v) -> v+1);
            }
        });

        AtomicInteger previousValue = new AtomicInteger();
        AtomicReference<String> mostRepeated = new AtomicReference<>("");
        wordToRepetition.forEach((key, value) -> {
            if(value > previousValue.get()){
                mostRepeated.set(key);
                previousValue.set(value);
            }

        });

        System.out.println("mostRepeatedWord=> "+mostRepeated.get());
        return mostRepeated.get();
    }


    /**
     * Tutorial solution
     * @param input
     * @return
     */
    private static String mostRepeatedWordV2(String input){

        String inputToUpperCase = input.toUpperCase();
        List<String> words = Arrays.asList(inputToUpperCase.split("[,\s]"));

        Map<String, Integer> wordToRepetition = new LinkedHashMap<>();
        words.forEach( word ->{
            if(!wordToRepetition.containsKey(word)){
                wordToRepetition.put(word, 1);
            }else{
                wordToRepetition.put(word, wordToRepetition.get(word)+1);
            }
        });

        int maxRepeated = 0;
        String mostRepeated = "";
        for(String wordKey: wordToRepetition.keySet()){
            if(wordToRepetition.get(wordKey) > maxRepeated){
                mostRepeated = wordKey;
            }
            maxRepeated = wordToRepetition.get(wordKey);
        }

        System.out.println("mostRepeatedWordV2=> "+mostRepeated);
        return mostRepeated;
    }


    public static void main(String[] args) {
        mostRepeatedWord("The one car is the most beatiful car,I love my car, one one");
        mostRepeatedWordV2("The one car is the most beatiful car,I love my car, one one");

    }
}
