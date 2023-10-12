package org.isaacsoriano.unit17;

import org.isaacsoriano.unit10.Heroes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LambdaHeroes {

    public static void main(String[] args) {
        ArrayList<Heroes.Hero> heroes = new ArrayList<Heroes.Hero>();
        heroes.addAll(Heroes.ALL);

        // ?

        System.out.println(heroes.stream().allMatch(s -> s.yearFirstAppearance() > 1900));
        System.out.println(heroes.stream()
                .anyMatch(s -> s.yearFirstAppearance() >= 1950 && s.sex().equals(Heroes.Hero.Sex.FEMALE)));
        System.out.println(heroes.stream().max((s, o) -> {
            if (s.yearFirstAppearance() < o.yearFirstAppearance()) return 1;
            else if (s.yearFirstAppearance() == o.yearFirstAppearance()) return 0;
            else return -1;
        }));
        System.out.println(heroes.stream().max((s, o) -> {
            int s_diff = Math.abs(s.yearFirstAppearance() - 1960);
            int o_diff = Math.abs(o.yearFirstAppearance() - 1960);
            if (s_diff < o_diff) return 1;
            else if (s_diff == o_diff) return 0;
            else return -1;
        })); // Este no rula

        StringBuilder stringBuilder = new StringBuilder();
        heroes.stream().forEach(s -> stringBuilder.append(s.yearFirstAppearance() + ", "));
        System.out.println(stringBuilder);

        StringBuilder collectedYears =
                heroes.stream().collect(
                        StringBuilder::new,
                        ( sb, hero ) -> sb.append( sb.isEmpty() ? "" : "," )
                                .append( hero.yearFirstAppearance() ),
                        ( sb1, sb2 ) -> sb1.append( sb2.isEmpty() ? "" : "__" + sb2 ) );
        System.out.println( collectedYears );

        Map<Heroes.Hero.Sex, List<Heroes.Hero>> sexMap = heroes.stream().collect(Collectors.groupingBy(s -> s.sex()));
        Map<Boolean, List<Heroes.Hero>> map1970 = heroes.stream().collect(Collectors.partitioningBy(s -> s.yearFirstAppearance() >= 1970));
        System.out.println(map1970);

        // Map<Heroes.Hero.Sex, ArrayList<Heroes.Hero>> sexMap = new HashMap<>();
        sexMap.put(Heroes.Hero.Sex.MALE, new ArrayList<>());
        sexMap.put(Heroes.Hero.Sex.FEMALE, new ArrayList<>());
        heroes.stream().forEach(s -> {
            sexMap.get(s.sex()).add(s);
        });
        System.out.println(sexMap);

        Map<Boolean, ArrayList<Heroes.Hero>> after1970Map = new HashMap<>();
        after1970Map.put(true, new ArrayList<>());
        after1970Map.put(false, new ArrayList<>());
        heroes.stream().forEach(s -> {
            after1970Map.get(s.yearFirstAppearance() >= 1970).add(s);
        });
        System.out.println(after1970Map);

        // Intermediäre Operationen

        System.out.println(heroes.stream().filter(s -> s.sex() == Heroes.Hero.Sex.FEMALE).count());
        heroes.stream().sorted((s, o) -> Integer.compare(s.yearFirstAppearance(), o.yearFirstAppearance())).forEach(System.out::println);


    }
}
