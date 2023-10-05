package org.isaacsoriano.unit15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalTime;

public class FileChangeWatcher implements Runnable {

    public static void main(String[] args) {
        FileChangeWatcher fileChangeWatcher = new FileChangeWatcher("FileToBeCHanged");
        new Thread(fileChangeWatcher).start();

    }

    private String fileName;
    private FileTime fileTime;

    public FileChangeWatcher(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        while (true) {
            FileTime newFileTime;

            try {
                newFileTime = Files.getLastModifiedTime(Path.of(fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (newFileTime != null && !newFileTime.equals(fileTime)) {
                fileTime = newFileTime;
                System.out.println("File changed! " + LocalTime.now().toString());
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
