package org.example.file.filecreation;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Directories {
    public static void main(String[] args) {
        FilenameFilter filesFilter = (file, fileName)->{
            return fileName.contains(".");
        };

        String[] contents = new File("src/main/resources/files/").list(filesFilter);
        Arrays.stream(contents).forEach(System.out::println);

        new File("src/main/resources/files/createdDir").mkdir();
    }
}
