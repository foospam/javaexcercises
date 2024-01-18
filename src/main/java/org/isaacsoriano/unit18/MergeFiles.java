package org.isaacsoriano.unit18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class MergeFiles {

    public static void mergeFiles(Path main, Path... temp) throws IOException {
        Iterable<Path> paths = Stream.concat(Stream.of(main), Stream.of(temp))::iterator;
        Collection<String> words = new LinkedHashSet<>();

        for (Path path: paths) {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(words::add);
        }
        Files.write(main, words);
    }
}
