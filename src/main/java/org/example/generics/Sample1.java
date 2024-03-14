package org.example.generics;

import java.util.ArrayList;
import java.util.List;

public class Sample1 {

    public static void main(String[] args) {

        List l1 = new ArrayList();
        l1.add("hi");
        l1.add(true);

        // System.out.println((Boolean) l1.get(0)); ClassCastException
        System.out.println((Boolean) l1.get(1));

        //Using generics
        List<String> l2 = new ArrayList();
        l2.add("hi");
        l2.add("How are you doing");
        System.out.println((String) l1.get(0));
        System.out.println((String) l1.get(1));
    }
}
