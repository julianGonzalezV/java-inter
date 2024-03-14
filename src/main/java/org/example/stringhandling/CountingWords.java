package org.example.stringhandling;

import java.util.HashMap;
import java.util.Map;

public class CountingWords {

    private static Map<String, Integer> count(String text){
        Map<String, Integer> result = new HashMap();
        String[] words = text.split(" ");

        for(int i= 0; i<words.length; i++){
            String key = words[i];
            if(result.containsKey(key)){
                result.compute(key, (k,v) -> v+1);
            }else{
                result.put(key, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(count("hello how are you"));
        System.out.println(count("hello how are you ? A/ I'm good and you ?"));
    }
}
