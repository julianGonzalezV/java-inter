package org.example.collections.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetSample {

    private static List<Integer> removeDuplicated(int[] arr){
        Set<Integer> unrepeatedElements = new HashSet<>();
        Arrays.stream(arr).forEach(item -> unrepeatedElements.add(item));
        return  unrepeatedElements.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicated(new int[]{1,2,3,4,1,2}));
    }
}
