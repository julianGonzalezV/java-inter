package org.example.collections.hashds;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Use a Key-Value pairs and a hashing function to insert and organize their data
 * Most common used in interviews
 *
 * The hash function: Maps the key or object to specific hash
 *
 * Implementations:
 *
 *  HashMap: it's not thread safe Generally,  it provides flexibility and best performance
 *  Hashtable: Similar to HashMap but thread safe
 *  HashSet: I does not allow duplicated
 *
 * Advantages: Searching is O(1) unless all items are stored in the same key slot
 *
 * Disadvantage: Require more memory
 *
 */
public class HashBasedStructureSamples {

    private static void getWordToNum(){
        Map<String, Integer> wordToNum = new HashMap<>();
        wordToNum.put("ONE", 1);
        wordToNum.put("TWO", 2);
        wordToNum.put("THREE", 3);
        wordToNum.put("FOUR", 4);
        wordToNum.put("FIVE", 5);
        System.out.println();

        System.out.println("TWO => "+wordToNum.get("TWO"));

        List<Integer> values = wordToNum.values().stream().toList();//Order is not ensured
        System.out.println("values: "+values);

        Set<String> keys = wordToNum.keySet();
        System.out.println("keys: "+keys);

        wordToNum.remove("FIVE");
        System.out.println("After removing five => "+wordToNum);

    }

    private static List<String> filterValues(Map<String, String> data, String valueToFilter){
        List<String> fullData = data.keySet().stream()
                .filter(key -> key.toLowerCase().startsWith(valueToFilter.toLowerCase()))
                .collect(Collectors.toList());

        fullData.addAll(data.values().stream()
                .filter( value -> value.toLowerCase().startsWith(valueToFilter.toLowerCase()))
                .collect(Collectors.toList()));

        Collections.sort(fullData);

        return fullData;
    }

    private static Map<String, String> getData(){
        Map<String, String> data = new HashMap<>();
        data.put("Hello", "Im here");
        data.put("My name is", "Julian");
        data.put("Job", "As software developer");
        data.put("Front", "Angular");
        data.put("Back", "Java");
        data.put("Other", "Analysis");
        data.put("ABC", "def");
        return data;
    }

    private static LinkedHashMap<String, Integer> phoneNumbers(){
        LinkedHashMap phones = new LinkedHashMap(4,0.75F, true);
        phones.put("Samuel",123);
        phones.put("Paola",1234);
        phones.put("Andres",1235);
        phones.put("Matias",1236);

        return phones;
    }




    public static void main(String[] args) {
        getWordToNum();

        System.out.println("FILTER VALUES");
        System.out.println(filterValues(getData(), "a"));
        System.out.println(filterValues(getData(), "A"));

        System.out.println("PHONES");
        System.out.println(phoneNumbers());
        Set<Map.Entry<String,Integer>> entries = phoneNumbers().entrySet();
        entries.stream().forEach( x -> System.out.println(x.getKey()+" - "+x.getValue()));

    }
}
