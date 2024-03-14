package org.example.varargs;

import java.util.Arrays;

public class Varargs {

    public static void printList(String... items){
        Arrays.stream(items).forEach(System.out::println);
    }


    public static void main(String[] args) {
        printList("one");
        printList("two");
        printList("three");
    }
}
