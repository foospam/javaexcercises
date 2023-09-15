package org.isaacsoriano.unit9;

import java.util.Arrays;

public class StringsToInteger {

    public static void main(String[] args) {
        String[] strings = { "1", "234", "333" };
        int[] ints1 = parseInts( strings );                                // [1, 234, 333]
        int[] ints2 = parseInts( "1", "234", "333" );                      // [1, 234, 333]
        int[] ints3 = parseInts( "1", "ll234", "3", null, "99" );          // [1, 0, 3, 0, 99]
        int[] ints4 = parseInts( "Person", "Woman", "Man", "Camera, TV" ); // [0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.toString(ints3));
        System.out.println(Arrays.toString(ints4));
    }
    static int[] parseInts(String... numbers) {
        int[] parsedInts = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            try {
                int parsedInt = Integer.parseInt(numbers[i]);
                parsedInts[i] = parsedInt;
            }
            catch (NumberFormatException | NullPointerException e){
                System.out.printf(
                        "The element at position %d, \"%s\", does not have " +
                                "a valid numeric format%n.", i, numbers[i]);
            }
        }
        return parsedInts;
    }
}
