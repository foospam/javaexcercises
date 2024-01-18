package org.isaacsoriano.unit18;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileClone {
    public static void cloneFile(Path path) throws IOException {

        path = path.toAbsolutePath();
        String regex = "Copy (\\((\\d+)\\) )?of "+path.getFileName();
        Pattern pattern = Pattern.compile(regex);

        boolean[] found = new boolean[1];

        OptionalInt maxCopy = Files.list(path.getParent())
                .mapToInt(file -> {
                    String match = "";
                    try {
                        Matcher matcher = pattern.matcher(file.getFileName().toString());
                        if (matcher.find()) {
                            found[0] = true;
                            System.out.println(matcher.toString());
                            match = matcher.group(2);
                            return Integer.parseInt(match);
                        }
                        ;
                    } catch (Exception e) {
                        return 0;
                    }
                    return 0;
                }).max();


        int lastCopy = 0;
        if (found[0]) {
            lastCopy = Math.max(1, maxCopy.getAsInt());
        }
        System.out.println(maxCopy);
        System.out.println(maxCopy.getAsInt());

        Path target;
        if (lastCopy == 0) {
            target = Path.of(path.getParent().toString(), "Copy of "+path.getFileName().toString());
        }
        else {
            target = Path.of(path.getParent().toString(),
                    "Copy ("+(lastCopy+1)+") of "+path.getFileName().toString());
        }

        Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);
    }


    public static void main(String[] args) throws IOException {
        Path path = Path.of("textfile.txt");
        cloneFile(path);
    }
}
