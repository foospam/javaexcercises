package org.isaacsoriano.unit10;

import java.util.*;
import java.util.stream.Stream;

public class Heroes {

    public static void main(String[] args) {
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        heroes.addAll(ALL);
        System.out.println(heroes);
        //heroes.sort(CompareByYear);
        heroes.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return Integer.compare(o1.yearFirstAppearance(), o2.yearFirstAppearance());
            }
        });

        System.out.println(heroes);

        heroes.sort(new CompareByYearAndName());
        System.out.println(heroes);
    }

    private Heroes() { }

    public record Hero( String name, Heroes.Hero.Sex sex, int yearFirstAppearance ) {
        public enum Sex { MALE, FEMALE }
        public Hero {
            Objects.requireNonNull( name ); Objects.requireNonNull( sex );
        }
    }

    public static class Universe {
        private final String     name;
        private final List<Hero> heroes;

        public Universe( String name, List<Hero> heroes ) {
            this.name   = Objects.requireNonNull( name );
            this.heroes = Objects.requireNonNull( heroes );
        }

        public String name() { return name; }
        public Stream<Hero> heroes() { return heroes.stream(); }
    }

    private static class CompareByYear implements Comparator<Hero>{

        @Override
        public int compare(Hero o1, Hero o2) {
            return Integer.compare(o1.yearFirstAppearance(), o2.yearFirstAppearance());
        }
    };


    private static class CompareByName implements Comparator<Hero>{

        @Override
        public int compare(Hero o1, Hero o2) {
            return o1.name().compareTo(o2.name());
        }
    };

    private static class CompareByYearAndName implements Comparator<Hero>{

        @Override
        public int compare(Hero o1, Hero o2) {
        int first = new CompareByYear().compare(o1, o2);
        if (first != 0) return first;
        else return new CompareByName().compare(o1, o2);
        }
    }

    public static Comparator<Hero> CompareByYear = new Comparator<Hero>() {
        public int compare(Hero o1, Hero o2) {
            return Integer.valueOf(o1.yearFirstAppearance).compareTo(o2.yearFirstAppearance);
        }
    };

    // https://github.com/fivethirtyeight/data/tree/master/comic-characters
    private static final Hero DEADPOOL = new Hero( "Deadpool (Wade Wilson)", Hero.Sex.MALE, 1991 );
    private static final Hero LANA_LANG = new Hero( "Lana Lang", Hero.Sex.FEMALE, 1950 );
    private static final Hero THOR = new Hero( "Thor (Thor Odinson)", Hero.Sex.MALE, 1950 );
    private static final Hero IRON_MAN = new Hero( "Iron Man (Anthony 'Tony' Stark)", Hero.Sex.MALE, 1963 );
    private static final Hero SPIDERMAN = new Hero( "Spider-Man (Peter Parker)", Hero.Sex.MALE, 1962 );
    private static final Hero WONDER_WOMAN = new Hero( "Wonder Woman (Diana Prince)", Hero.Sex.FEMALE, 1941 );
    private static final Hero CAPTAIN_AMERICA = new Hero( "Captain America (Steven Rogers)", Hero.Sex.MALE, 1941 );
    private static final Hero SUPERMAN = new Hero( "Superman (Clark Kent)", Hero.Sex.MALE, 1938 );
    private static final Hero BATMAN = new Hero( "Batman (Bruce Wayne)", Hero.Sex.MALE, 1939 );

    public static final List<Hero> DC =
            List.of( SUPERMAN, LANA_LANG, WONDER_WOMAN, BATMAN );

    public static final List<Hero> MARVEL =
            List.of( DEADPOOL, CAPTAIN_AMERICA, THOR, IRON_MAN, SPIDERMAN );

    public static final List<Hero> ALL =
            Stream.concat( DC.stream(), MARVEL.stream() ).toList();

    public static final List<Universe> UNIVERSES =
            List.of( new Universe( "DC", DC ), new Universe( "Marvel", MARVEL ) );

}