package org.isaacsoriano.unit9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class AbcjsEditor {
    public static void main(String[] args) {
        String sourceFile = "src/main/java/org/isaacsoriano/unit9/notes_source.txt";
        String targetFile = "src/main/java/org/isaacsoriano/unit9/notes_target.txt";
        try {
            readWriteNotes(sourceFile, targetFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void readWriteNotes(String sourceFile, String targetFile) throws FileNotFoundException {

        String header = "M:C\nL:1/4\nK:C\n";

        StringBuilder buffer = new StringBuilder(header);

        try(Scanner scanner = new Scanner(new File(sourceFile));){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.matches("[A-Ga-g][,']?"))
                    buffer.append(line + " ");
            }
        }

        try(PrintWriter printWriter = new PrintWriter(new File(targetFile))){
            printWriter.print(buffer.toString());
        }



    }

}
