package org.example.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {

    //Based on Object as the parent class
    public static List arrayToListNonTypeSafe(Object[] array, List<Object> list){
        for(Object objec: array){
            list.add(objec);
        }
        return list;
    }

    public static void nonTypeSafeApproach(){
        Integer[] ints = new Integer[]{1,2,3};
        String[] strs = new String[]{"one", "two", "three"};
        Boolean[] boos = new Boolean[]{true,true,false};

        List<Integer> intList = arrayToListNonTypeSafe(ints, new ArrayList<>());
        List<String> strList = arrayToListNonTypeSafe(strs, new ArrayList<>());
        List<Boolean> booList = arrayToListNonTypeSafe(boos, new ArrayList<>());

        System.out.println(intList);
        System.out.println(strList);
        System.out.println(booList);
    }


    /**
     * T variable only has local scope
     * @param array
     * @param list
     * @return
     * @param <T>
     */
    public static <T> List<T> arrayToListTypeSafe(T[] array, List<T> list){
        for(T objec: array){
            list.add(objec);
        }
        return list;
    }

    public static void TypeSafeApproach(){
        Integer[] ints = new Integer[]{1,2,3};
        String[] strs = new String[]{"one", "two", "three"};
        Boolean[] boos = new Boolean[]{true,true,false};

        List<Integer> intList = arrayToListTypeSafe(ints, new ArrayList<>());
        List<String> strList = arrayToListTypeSafe(strs, new ArrayList<>());
        List<Boolean> booList = arrayToListTypeSafe(boos, new ArrayList<>());

        //List<String> booList2 = arrayToListTypeSafe(boos, new ArrayList<>()); // It is not allowed at compilation time
        // indeed, the IDE shows you the cast error

        System.out.println(intList);
        System.out.println(strList);
        System.out.println(booList);
    }

    public static void main(String[] args) {
        nonTypeSafeApproach();

        System.out.println("Type Safe");
        TypeSafeApproach();
    }
}
