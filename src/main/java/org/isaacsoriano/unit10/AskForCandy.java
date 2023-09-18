package org.isaacsoriano.unit10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class AskForCandy {
    public static void main(String[] args) {
        CandyType candy = CandyType.fromName("Licorice").get();
        System.out.println(candy.addictiveQuality());
        System.out.println(CandyType.CHEWING_GUMS.next());
        // NOTA: Arreglar esto, que simplemente me está devolviendo el siguiente de la lista

    }



}

enum CandyType {
    CARAMELS, CHOCOLATE, GUMMIES, LICORICE, LOLLIPOPS, CHEWING_GUMS, COTTON_CANDY;
    private final int ADDICTIVE_QUALITY;
    CandyType(){
        ADDICTIVE_QUALITY = switch(this.name()) {
            case "CARAMELS" -> 9;
            case "CHOCOLATE" -> 5;
            case "GUMMIES" -> 4;
            case "LICORICE" -> 3;
            case "LOLLIPOPS" -> 2;
            case "CHEWING_GUMS" -> 3;
            case "COTTON_CANDY" -> 1;
            default -> 0;
        };
    }

    private static final Comparator<CandyType> CompareByAddictiveQuality =
            new Comparator<CandyType>() {
                @Override
                public int compare(CandyType o1, CandyType o2) {
                    return Integer.compare(o1.addictiveQuality(), o2.addictiveQuality());
                }
            };

    public CandyType next(){
        return next(this.name());
    }

    private static CandyType next(String candyName){
        ArrayList<CandyType> candyList = new ArrayList<CandyType>();
        for (CandyType candy : CandyType.values()) {
            candyList.add(CandyType.fromName(candy.name()).get());
        }

        candyList.sort(CompareByAddictiveQuality);
        for (int i = 0; i < candyList.size(); i++) {
            if (candyList.get(i).name().equals(candyName)) {
                if (i < candyList.size() -1) return candyList.get(i+1);
                else return candyList.get(i);
            }
        }

        return CandyType.fromName(candyName).get();
    }

    int addictiveQuality(){
        return this.ADDICTIVE_QUALITY;
    }
    static Optional<CandyType> fromName(String input){
        input = input.toUpperCase().trim().replace(' ', '_');
        return Optional.of(CandyType.valueOf(input));
    }

    static CandyType random(){
        return CandyType.values()[(int) (Math.random() * values().length)];
    }
}


