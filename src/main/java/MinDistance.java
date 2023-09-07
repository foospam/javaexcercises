import java.awt.Point;

public class MinDistance {
    public static void main(String[] args) {
        Point[] points = {new Point(10, 20), new Point(12, 2), new Point(44, 4)};
        System.out.println(minDistance(points, 3));
        System.out.println(nextPoint(points, 3));
    }


    private static double minDistance(Point[] points, int size) throws IllegalArgumentException {

        if (points.length != size) throw new IllegalArgumentException("The size of the array must be " + size + "!");

        double minDistance = Double.MAX_VALUE;
        Point centerPoint = new Point();

        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException("The element at index " + size + " is null!");
            minDistance = Math.min(minDistance, centerPoint.distance(points[i]));
        }

        return minDistance;
    }

    private static Point nextPoint(Point[] points, int size) throws IllegalArgumentException {
        if (points.length != size) throw new IllegalArgumentException("The size of the array must be " + size + "!");

        double minDistance = Double.MAX_VALUE;
        Point nextPoint = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point centerPoint = new Point();

        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException("The element at index " + size + " is null!");
            Point currentPoint = points[i];
            double currentDistance = centerPoint.distance(points[i]);

            if (currentDistance <= minDistance) {
                minDistance = currentDistance;
                nextPoint = currentPoint;
            }
        }
        return nextPoint;
    }


}
