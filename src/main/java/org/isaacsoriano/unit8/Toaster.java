package org.isaacsoriano.unit8;

public class Toaster {
    int capacity;
    boolean stainless;
    boolean extraLarge;

    @Override
    public boolean equals(Object o) {

        if (o instanceof Toaster toaster &&
                capacity == toaster.capacity &&
                stainless == toaster.stainless &&
                extraLarge == toaster.extraLarge) return true;
        else return false;

        /**
         * Aus der Lösung:
         *
         * return o instanceof Toaster toaster && ... && ... &&,
         *
         */
    }
}