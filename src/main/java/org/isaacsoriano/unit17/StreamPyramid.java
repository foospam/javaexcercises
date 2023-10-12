package org.isaacsoriano.unit17;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPyramid {
    public static void main(String[] args) {
        System.out.println(writePyramyd(5));
    }

    public static String writePyramyd(int size){
        return IntStream.rangeClosed(1, size)
                .mapToObj(s -> (int) s)
                .map(s -> " ".repeat((size - s)) + "/\\".repeat(s))
                .collect(Collectors.joining("\n"));
    }
}
