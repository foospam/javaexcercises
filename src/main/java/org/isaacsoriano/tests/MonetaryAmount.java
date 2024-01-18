package org.isaacsoriano.tests;

import org.isaacsoriano.unit9.IllegalWattException;

import java.io.Serializable;

public class MonetaryAmount implements Serializable {

    private double value;

    private MonetaryAmount() { }

    // Erzeugen von immutable MonetaryAmount-Objekten durch Fabrikmethode
    public static MonetaryAmount of( double value ) throws IllegalArgumentException {

        if (value < 0) throw new IllegalArgumentException("A monetary amount must be positive!");

        MonetaryAmount result = new MonetaryAmount();
        result.value = value;
        return result;
    }

    // liefert den Wert
    public double value() {
        return this.value;
    }
    public String toString() { return ""; }

    // MonetaryAmount-Objekte soll man mit equals(Object o) vergleichen können
    public boolean equals( Object o ) {
        if (o instanceof MonetaryAmount) {
            MonetaryAmount other = (MonetaryAmount) o;
            return this.value == other.value();
        }
        return false;
    }

    //
    public MonetaryAmount add( MonetaryAmount value ) {

        double result = this.value + value.value();
        try {
            return MonetaryAmount.of(result);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("You can't substract a greater monetary amount to a lesser monetary amoung!");
        }

    }
    public MonetaryAmount subtract( MonetaryAmount value ) throws IllegalArgumentException{
        double result = this.value - value.value();
        try {
            return MonetaryAmount.of(result);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("You can't substract a greater monetary amount to a lesser monetary amoung!");
        }
    }

}
