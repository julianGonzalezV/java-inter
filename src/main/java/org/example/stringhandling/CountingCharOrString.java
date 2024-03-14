package org.example.stringhandling;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountingCharOrString {

    private static Map<String, Integer> wordsCount(String tex){
        Map<String, Integer> stringToCount = new HashMap();
        String[] words = tex.split(" ");
        for(int i= 0 ; i<words.length; i++){
            String key = words[i];
            //StringToCount.compute(key, (k,v) -> (v==null)? 1:v+1);--SHORTER approach
            if(stringToCount.get(key) == null){
                stringToCount.put(key, 1);
            }else{
                stringToCount.put(key, stringToCount.get(key)+1);
            }
        }
        return stringToCount;
    }

    private static Map<Character, Integer> charsCount(String text){
        Map<Character, Integer> result = new HashMap<>();
        String normalized = text.replaceAll(" ","");
        char[] charArray = normalized.toCharArray();
        for(int i=0; i<charArray.length; i++){
            result.compute(charArray[i], (k,v)-> (v==null)? 1: v+1);
        }

        return result;
    }

    private static boolean canBeExtractedFrom(String from, String extract){
        Map<String, Integer> fromCount =  wordsCount(from);
        String[] extractWords = extract.split(" ");
        for (String word:extractWords) {
            if(fromCount.get(word)>0){
                fromCount.put(word,fromCount.get(word)-1);
            }else{
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordsCount("this is a sample and other sample"));
        System.out.println(charsCount("this is a sample and other sample"));
        System.out.println(canBeExtractedFrom("this is a sample and other sample", "sample sample"));
    }
}
