package org.example.file.filecreation;

import java.io.File;
import java.io.IOException;

public class FileCreation {
    public static void main(String[] args) {
        File file = new File("src/main/resources/files/created-sample.txt");
        try {
           boolean fileCreated = file.createNewFile();
            System.out.println(fileCreated);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
