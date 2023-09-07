public class PleasantMultiplication {

    public static void main(String[] args) {

        System.out.println(RecursiveMultiplication(7, 6));
        System.out.println(IterativeMultiplication(7,6));
    }

    static long RecursiveMultiplication(long a, long b) {
        return RecursiveMultiplication(a, b, 0);
    }

    static long RecursiveMultiplication(long multiplicator, long multiplicand, long c) {
        System.out.printf("Multiplicator: %d Multiplicand: %d Correction: %d%n", multiplicator, multiplicand, c);

        if (multiplicator == 1) return multiplicand + c;
        else {
            if ((multiplicator - 1) / 2 == multiplicator / 2) c += multiplicand;
            return RecursiveMultiplication(multiplicator / 2, multiplicand * 2, c);
        }
    }

    static long IterativeMultiplication(long multiplicator, long multiplicand) {
        int correction = 0;
        while (multiplicator > 1) {
            System.out.printf("Multiplicator: %d Multiplicand: %d Correction: %d%n",
                    multiplicator, multiplicand, correction);
            if ((multiplicator - 1) / 2 == multiplicator / 2) correction += multiplicand;
            multiplicator /= 2;
            multiplicand *= 2;
        }
        System.out.printf("Multiplicator: %d Multiplicand: %d Correction: %d%n",
                multiplicator, multiplicand, correction);

        return multiplicand + correction;
    }
}
