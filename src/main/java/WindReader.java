public class WindReader {
    public static void main(String[] args) {
        int[] windSpeed = new int[3];
        int[] windDirection = new int[3];
        setArrayIntValues(windSpeed, 200);
        setArrayIntValues(windDirection, 360);
        printWindArrays(windSpeed, windDirection);
    }

    private static void setArrayIntValues(int[] array, int range) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * range);
        }
    }

    private static void printWindArrays(int[] windSpeed, int[] windDirection) {
        for (int i = 0; i < windSpeed.length; i++) {
            System.out.printf("Wind speed %d km/h and wind direction %d°%s",
                    windSpeed[i], windDirection[i], i < windSpeed.length - 1 ? ", " : "\n");
        }
    }
}
