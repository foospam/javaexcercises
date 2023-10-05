package org.isaacsoriano.unit10;

public class DistanceImplementations {

    public static void main(String[] args) {
        System.out.println(Distances.EUCLIDEAN.distance(0,0,2,2));
        System.out.println(Distances.MANHATTAN.distance(0,0,2,2));

    }

}

enum Distances implements Distance {
    EUCLIDEAN, MANHATTAN;

    @Override
    public double distance(double x1, double y1, double x2, double y2) {
        return switch (this) {
            case EUCLIDEAN -> Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            case MANHATTAN -> Math.abs(x1 - x2) + Math.abs(y1 - y2);
        };
    }

    @Override
    public double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return switch (this) {
            case EUCLIDEAN -> Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
            case MANHATTAN -> Math.abs(x1-x2) + Math.abs(y1-y2) + Math.abs(z1-z2);
        };
    }
}

interface Distance {
    double distance(double x1, double y1, double x2, double y2);

    double distance(double x1, double y1, double z1, double x2, double y2, double z2);
}

/* FRAGE AN CHRISTIAN: IM BUCH WURDE DAS MIT OVERRIDE FÜR JEDEN WERT DER AUSZÄHLUNG GEMACHT. IST DIE LÖSUNG MIT DEM SWITCH
FALSCH?
 */