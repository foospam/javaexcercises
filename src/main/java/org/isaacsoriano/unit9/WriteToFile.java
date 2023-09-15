package org.isaacsoriano.unit9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "Date.txt";
        File file = new File(fileName);

        Scanner fileReader = new Scanner(file);
        StringBuilder buffer = new StringBuilder();

        while(fileReader.hasNextLine()){
            buffer.append(fileReader.nextLine());
            buffer.append("\n");
        }
        fileReader.close();

        try (PrintWriter printWriter = new PrintWriter(file);
             Scanner scanner = new Scanner(System.in)) {
            printWriter.print(buffer.toString());

            while (true) {
                System.out.print(">");
                String nextLine = scanner.nextLine();
                if (nextLine.equals("exit")) break;
                else printWriter.println(nextLine);
            }
        } catch (IOException e) {
            System.err.println("Can't create file "+fileName);
        }


    }

}
