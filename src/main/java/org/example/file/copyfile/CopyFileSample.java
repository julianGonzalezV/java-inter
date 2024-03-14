package org.example.file.copyfile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFileSample {
    public static void main(String[] args) {
        Path sourceFile = Paths.get("src/main/resources/files/example.txt");
        Path newFile = Paths.get("src/main/resources/files/example-new.txt");
        try {
            Files.copy(sourceFile, newFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
