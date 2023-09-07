public class Collatz {
    public static void main(String[] args) {
        collatz(38);

    }

    static void collatz(long n) {
        long max = 0;
        collatz(n, max);
    }

    static void collatz(long n, long max) {
        max = Math.max(n, max);
        System.out.println(n);

        if (n != 1) {
            if (n % 2 == 0) {
                collatz(n / 2, max);
            } else collatz(3 * n + 1, max);
        } else {
            System.out.println("Maximum value: " + max);
        }
    }
}
