import java.awt.*;
import java.sql.SQLOutput;

public class BermudaTriangle {
    final static int DIMENSION = 50;
    final static String RAINBOW = "\uD83C\uDF08";
    final static String FOG = "\uD83C\uDF2B";
    final static String OCTOPUS = "\uD83D\uDC19";

    private static boolean inBorder(int x, int y, Polygon polygon) {
        return !polygon.contains(x - 1, y - 1) ||
                !polygon.contains(x - 1, y) ||
                !polygon.contains(x - 1, y + 1) ||
                !polygon.contains(x, y - 1) ||
                !polygon.contains(x, y + 1) ||
                !polygon.contains(x + 1, y - 1) ||
                !polygon.contains(x + 1, y) ||
                !polygon.contains(x + 1, y + 1);
    }

    public static void main(String[] args) {
        java.awt.Polygon triangle = new Polygon();
        triangle.addPoint(3, 3);
        triangle.addPoint(43, 7);
        triangle.addPoint(25, 40);
        System.out.println(triangle.contains(14, 1));

        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                if (triangle.contains(x, y)) {
                    if (inBorder(x, y, triangle)) System.out.print(RAINBOW);
                    else System.out.print(OCTOPUS);
                } else System.out.print(FOG);
            }
            System.out.println();
        }


    }

    static Polygon resetWithRandomTriangle(Polygon polygon) {
        polygon.reset();
        for (int i = 0; i < 3; i++)
            polygon.addPoint((int) Math.random() * DIMENSION, (int) Math.random() * DIMENSION);
        return polygon;
    }

    static Polygon createRandomTriangle() {
        return resetWithRandomTriangle(new Polygon());
    }

}
