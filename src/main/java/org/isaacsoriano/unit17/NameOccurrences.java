package org.isaacsoriano.unit17;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NameOccurrences {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{ "Anne", "Captain CiaoCiao", "Balico", "Charles", "Anne",
                "CiaoCiao", "CiaoCiao", "Drake", "Anne", "Balico", "CiaoCiao" });


        Map<String, Long> map = list.stream().map(s -> s.equals("CiaoCiao") ? "Captain CiaoCiao" : s)
                .collect(Collectors.groupingBy(String::toLowerCase,
                        Collectors.counting()));

        System.out.println(map);

    }


}
