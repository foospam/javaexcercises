package org.isaacsoriano.unit18;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.awt.Desktop;

public class Motivation {

    public static void main(String[] args) {

        String fileContent = """
                <!DOCTYPE html><html><body>
                ›Die Dinge, die wir stehlen, sagen uns, wer wir sind.‹
                - Thomas von Tew
                </body></html>
                """;

        try {
            Path motivation = Files.createTempFile("motivation", ".html");
            Files.writeString(motivation, fileContent);
            Desktop.getDesktop().browse(motivation.toUri());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
