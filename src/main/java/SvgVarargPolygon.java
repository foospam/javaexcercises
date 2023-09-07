public class SvgVarargPolygon {
    public static void main(String[] args) {
        printSvgPolygon( 200, 10, 250, 190, 131, 343);
    }

    public static void printSvgPolygon(int... points){
        if (points.length % 2 == 1) throw new IllegalArgumentException("The number of arguments must be even!");

        System.out.printf("<polygon points=\"");

        for (int i = 0; i < points.length-1; i += 2) {
            System.out.printf("%d,%d%s", points[i], points[i+1],
                    i < points.length -2 ? " " : "");
        }

        System.out.printf("\"/>%n");
    }
}
