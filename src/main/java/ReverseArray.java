public class ReverseArray {
    public static void main(String[] args) {
        double[] dailyGains  = { 1000, 2000, 500, 9000, 9010, 9020 };
        printArray(dailyGains);
        reverse(dailyGains);
        printArray(dailyGains);

    }

    private static void reverse( double[] numbers ) throws NullPointerException{
        if (numbers == null) throw new NullPointerException("The array is null!");
        for (int i = 0; i < numbers.length/2; i++) {
            double t = numbers[i];
            numbers[i] = numbers[numbers.length-1-i];
            numbers[numbers.length-1-i] = t;
        }
    }

    private static void printArray( double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", (int) array[i]);
        }
        System.out.println();
    }
}
