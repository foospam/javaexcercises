package org.isaacsoriano.unit18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

public class FileAttributes {

    public static void main(String[] args) {
        Path path = Path.of("textfile.txt");
        try {
            BasicFileAttributes basicattributes = Files.readAttributes(path, BasicFileAttributes.class);
            DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);

            System.out.println(basicattributes.size());
            System.out.println(basicattributes.lastAccessTime());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
