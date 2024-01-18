package org.isaacsoriano.unit18;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public class DosDir {

    public static void main(String[] args) {

        Path dir = Path.of("", "");

        try {
            DirectoryStream<Path> paths = Files.newDirectoryStream(dir);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
