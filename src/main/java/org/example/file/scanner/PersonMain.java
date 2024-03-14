package org.example.file.scanner;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// in: is an InputStream for reading standard input
        System.out.println("Person name");
        String name = scanner.next();
        System.out.println("Person age");
        int age = scanner.nextInt();
        System.out.println("Person phone number");
        long phoneNumber = scanner.nextLong();

        Person person = new Person(age, name, phoneNumber);
        System.out.println(person);
    }
}
