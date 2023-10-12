package org.isaacsoriano.unit17;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DecadesArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decades(1929, 1979)));
    }

    public static int[] decades(int start, int end) {
        return IntStream.rangeClosed(start / 10, end / 10).map(s -> s * 10).toArray();
    }
}