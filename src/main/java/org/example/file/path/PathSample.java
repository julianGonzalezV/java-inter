package org.example.file.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * PATH <interface> Good way to move, copy, and delete files
 */
public class PathSample {
    public static void main(String[] args) {
        // Create the file src/main/resources/files/deleteMe.txt previous to execute this code
        Path path = Paths.get("src/main/resources/files/deleteMe.txt");
        Path path2 = Paths.get("/src/main/resources/files/example.txt");
        System.out.println(path2.getParent());
        System.out.println(path2.getRoot());
        System.out.println(path2.getFileName());
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
