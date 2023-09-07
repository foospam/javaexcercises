public class Sudoku3x3Tester {
    public static void main(String[] args) {
        int[][] array = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        testSudoku(array);

        int[][] array2 = { { 1, 2, 3 }, { 4, 4, 6 }, { 7, 8, 8 } };

        testSudoku(array2);
    }

    public static void testSudoku(int[][] sudoku){
        boolean[] numberOccurrency = new boolean[9];

        for (int row = 0; row < sudoku.length; row++) {
            for (int column = 0; column < sudoku[row].length; column++) {
                int occurrencyIndex = sudoku[row][column] -1;
                numberOccurrency[occurrencyIndex] = true;
            }

        }

        boolean result = true;

        for (int i = 0; i < numberOccurrency.length; i++) {
            if (!numberOccurrency[i]) System.out.printf("Missing %d%n", i+1);
        }

    }
}
