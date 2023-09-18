package org.isaacsoriano.unit10;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import java.util.Collection;
import java.util.Comparator;

public class StoreFinder {

    public static void main(String[] args) {
        Store store1 = new Store(new Point(1,3), "Store1");
        Store store2 = new Store(new Point(13,3), "Store2");
        Store store3 = new Store(new Point(13,4), "Store3");
        Store store4 = new Store(new Point(-3,1), "Store4");
        Store store5 = new Store(new Point(-2,2), "Store5");
        ArrayList<Store> storeList = new ArrayList<Store>();
        storeList.add(store1);
        storeList.add(store2);
        storeList.add(store3);
        storeList.add(store4);
        storeList.add(store5);
        System.out.println(storeList);
        ArrayList<Store> storeList2 = (ArrayList<Store>) findStoresAround(storeList, new Point(0,0));
        System.out.println(storeList2);

    }

    public static record Store(Point location, String name){

    }


    public static List<Store> findStoresAround(Collection<Store> stores, Point center){
        ArrayList<Store> storeArrayList = new ArrayList<Store>();
        storeArrayList.addAll(stores);
        storeArrayList.sort(new Comparator<Store>(){

            @Override
            public int compare(Store o1, Store o2) {
                return Double.compare(o1.location.distance(center), o2.location.distance(center));
            }
        });

        return (List<Store>) storeArrayList;
    }
}

/*
Lege ein neues Record Store an.

Gib dem Store zwei Objektvariablen Point location und String name.

Sammle diverse Store-Objekte in einer Liste.

Schreibe eine Methode List<Store> findStoresAround(Collection<Store> stores, Point center), die eine Liste zurückliefert, nach Abständen zum center sortiert; vorne in der Liste stehen diejenigen, die der Destillerie am nächsten sind.
 */

