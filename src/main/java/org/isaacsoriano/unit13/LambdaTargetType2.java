package org.isaacsoriano.unit13;

import java.util.function.DoubleSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.UnaryOperator;

public class LambdaTargetType2 {
    public static void main(String[] args) {
        DoubleSupplier ds = () -> {return 0;};
        LongToDoubleFunction ltdf = (long a) ->  {return 0;};
        UnaryOperator<String> up = (String string) -> {return "";};
    }
}
