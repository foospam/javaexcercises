package org.isaacsoriano.unit10;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class PointComparatorDemo {

    public static void main(String[] args) {
        Point[] points = { new Point( 9, 3 ), new Point( 3, 4 ), new Point( 4, 3 ), new Point( 1, 2 ) };
        Arrays.sort( points, new PointDistanceToZeroComparator() );
        System.out.println( Arrays.toString( points ) );
    }

    static class PointDistanceToZeroComparator implements Comparator<Point>{

        @Override
        public int compare(Point o1, Point o2) {
            return Double.compare(o1.distance(0,0), o2.distance(0,0));
        }
    }
}
