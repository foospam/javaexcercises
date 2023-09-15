package org.isaacsoriano.unit9;

import javax.tools.StandardJavaFileManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LongestLineInFile {
    public static void main(String[] args) {

        try {
            String filename = "src\\main\\java\\org\\isaacsoriano\\unit9\\family-names.txt";
            Path path = Paths.get(filename);
            List<String> strings = Files.readAllLines(path);
            int maxLength = 0;
            String longestWord = "";
            String secondLongestWord = "";
            for (String string : strings) {
                if (string.length() >= maxLength) {
                    maxLength = string.length();
                    secondLongestWord = longestWord;
                    longestWord = string;
                }
            }
            System.out.println(longestWord+" and "+secondLongestWord);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
