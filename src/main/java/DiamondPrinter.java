public class DiamondPrinter {
    public static void main(String[] args) {
        printDiamonds(11);
        printDiamonds(10);

    }

    private static void printDiamonds(int size) {
        int MAXIMUM_BREADTH = ('Z'-'A') * 2 -1;

        if (size % 2 == 0)
            throw new IllegalArgumentException("The size must be an odd number greater than 0!");
        else if (size > MAXIMUM_BREADTH)
            throw new IllegalArgumentException("The size must be <= " + MAXIMUM_BREADTH + "!");

        int current_breadth = 1;
        int rowCount = 0;
        while (rowCount < size) {
            for (int i = 0; i < size - current_breadth; i++) {
                System.out.print(" ");
            }

            char c = 'A';
            for (int i = 0; i < current_breadth; i++) {
                c = (char) ('A' + i);
                System.out.print(c);
            }

            while (c > 'A') {
                c -= 1;
                System.out.print(c);
            }

            System.out.println();
            rowCount++;

            if (rowCount < size / 2 + 1) current_breadth++;
            else current_breadth--;
        }
    }
}
