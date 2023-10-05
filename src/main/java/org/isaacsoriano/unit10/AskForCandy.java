package org.isaacsoriano.unit10;

import java.lang.reflect.Array;
import java.util.*;

public class AskForCandy {
    public static void main(String[] args) {
        CandyType candy = CandyType.fromName("Licorice").get();
        System.out.println(candy.addictiveQuality());
        System.out.println(CandyType.LOLLIPOPS.next());
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

    private static final Map<Integer, ArrayList<CandyType>> addictionMap = new HashMap<Integer, ArrayList<CandyType>>();

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

    private static void fillAddictionMap(){
        for (CandyType candy : CandyType.values()){
            Integer addiction = candy.addictiveQuality();
            if (!addictionMap.containsKey(addiction))
            {
                ArrayList<CandyType> newList = new ArrayList<>();
                newList.add(candy);
                addictionMap.put(addiction, newList);
            }
            else {
                ArrayList<CandyType> oldList = addictionMap.get(addiction);
                oldList.add(candy);
            }
        }
    }

    private static CandyType next(String candyName){
        if (addictionMap.isEmpty()) fillAddictionMap();

        int thisAddiction = CandyType.fromName(candyName).get().addictiveQuality();
        ArrayList<Integer> addictionValues = new ArrayList<Integer>();
        addictionValues.addAll(addictionMap.keySet());
        addictionValues.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        int thisAddictionIndex =addictionValues.indexOf(thisAddiction);
        if (thisAddictionIndex == addictionValues.size()-1)
            return CandyType.fromName(candyName).get();
        else {
            ArrayList<CandyType> resultArray = addictionMap.get(addictionValues.get(thisAddictionIndex + 1));
            return resultArray.get((int) (Math.random() * resultArray.size()));
        }
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


// FRAGE AN CHRISTIAN: IST DAS ZU KOMPLIZIERT?

