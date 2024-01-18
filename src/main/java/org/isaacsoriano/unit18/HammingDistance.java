package org.isaacsoriano.unit18;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HammingDistance {

    static long distance(Path file1, Path file2) {

        long distance = 0L;

        try (InputStream is1 = Files.newInputStream(file1, StandardOpenOption.READ);
             InputStream is2 = Files.newInputStream(file2, StandardOpenOption.READ);) {
            while (is1.available() > 0) {
                if (is1.read() != is2.read()) distance++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("hamming-distance-file1.txt");
        Files.writeString(path1, "To Err is Human. To Arr is Pirate.");
        Path path2 = Paths.get("hamming-distance-file2.txt");
        Files.writeString(path2, "To Arr is Human. To Err is Pirate!");
        System.out.println(distance(path1, path2));
    }
}
