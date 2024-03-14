package org.example.file.scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderSample {
    public static void main(String[] args) {
        File file = new File("src/main/resources/files/example.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) { // Try with resources to ensure they are closed
            // Buffer reader is threadsafe
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
