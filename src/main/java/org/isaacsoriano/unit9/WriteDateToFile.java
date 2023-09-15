package org.isaacsoriano.unit9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Scanner;

public class WriteDateToFile {
    public static void main(String[] args) {

        String fileName = "Date2.txt";
        File file = new File(fileName);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            String time = LocalDateTime.now().toString();
            printWriter.print(time);
        } catch (IOException e) {
            System.err.println("Can't create file " + fileName);
        }


    }

}
