package org.isaacsoriano.unit17;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GenerateAndFillArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fillNewArray(10,3)));
        System.out.println(fillNewArray(10,3).length);

    }

    public static int[] fillNewArray(int size, int value){
        return IntStream.range(value, value+size).map(s -> value).toArray();
    }
}
