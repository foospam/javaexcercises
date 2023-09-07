public class MountainVisualizer {
    public static void main(String[] args) {
        int[] altitudes = new int[]{0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0};
        printMountain(altitudes);
        printMountainExtension(altitudes);

    }

    private static void printMountain(int[] altitudes) {
        int MAX_ALTITUDE = 0;
        for (int altitude : altitudes) {
            MAX_ALTITUDE = Math.max(MAX_ALTITUDE, altitude);
        }

        for (int y = MAX_ALTITUDE; y >= 0; y--) {
            System.out.print(y);
            for (int x = 0; x < altitudes.length; x++) {
                System.out.print(altitudes[x] == y ? "*" : " ");
            }
            System.out.println();
        }

    }

    private static void printMountainExtension(int[] altitudes) {
        int MAX_ALTITUDE = 0;
        for (int altitude : altitudes) {
            MAX_ALTITUDE = Math.max(MAX_ALTITUDE, altitude);
        }

        for (int y = MAX_ALTITUDE; y >= 0; y--) {
            System.out.print(y);
            for (int x = 0; x < altitudes.length; x++) {
                char toPrint;

                if (altitudes[x] == y) {

                    int derivative;

                    if (x >= 1 && x + 1 < altitudes.length) {
                        derivative = derivativeAtA(altitudes[x], altitudes[x-1], altitudes[x+1]);
                    }
                    else derivative = (x < altitudes.length - 1) ?
                            derivativeAtA(altitudes[x], altitudes[x + 1]) :
                            -derivativeAtA(altitudes[x], altitudes[x - 1]);

                    toPrint = switch (derivative) {
                        case -1 -> '\\';
                        case 0 -> {
                            if (derivativeAtA(derivative,
                                derivativeAtA(altitudes[x-1], altitudes[x]),
                                derivativeAtA(altitudes[x+1], altitudes[x+2])) == -1) yield '^';
                            else yield '-';}
                        case 1 -> '/';
                        default -> ' ';
                    };
                } else toPrint = ' ';

                System.out.print(toPrint);
            }
            System.out.println();

        }
    }


    private static int derivativeAtA(int a, int post) {
        if (a == post) return 0;
        else if (a < post) return 1;
        else return -1;
    }

    private static int derivativeAtA(int a, int prev, int post){
        if (a > prev) {
            if (a > post) return 0;
            else return 1;
        }
        else if (a < prev) {
            if (a == post) return 0;
            else return -1;
        }
        else return 0;
    }
}

