package org.isaacsoriano.unit14;

import java.util.Locale;

public class RandomInEveryLocalePrinter {
    public static void main(String[] args) {
        for (Locale locale: Locale.getAvailableLocales()
             ) {
            double price = (double) (Math.random() * 2000 + 10000);
            System.out.printf(locale, "$ %,.2f%n", price);
        }
    }
}
