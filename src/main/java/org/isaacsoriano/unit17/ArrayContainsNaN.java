package org.isaacsoriano.unit17;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class ArrayContainsNaN {

    public static void main(String[] args) {
        Double[] array = new Double[]{313., 414., 552., 14214., Double.NaN};
        System.out.println(containsNan(array));
    }

    public static boolean containsNan(Double[] array){
        return Arrays.stream(array).anyMatch(s -> s.equals(Double.NaN));
    }
}
