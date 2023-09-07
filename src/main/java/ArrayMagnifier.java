public class ArrayMagnifier {
    public static void main(String[] args) {
        int[][] original = new int[][]{ {1, 2, 3},
                {4, 5, 6} };
        printMatrix(original);

        int[][] magnified = magnify(original,2);
        printMatrix(magnified);

        magnified = magnify(original,3);
        printMatrix(magnified);

    }

    private static int[][] magnify(int[][] array, int factor) {
        var ROW_NUMBER = array.length;
        var COLUMN_NUMBER = array[0].length;

        int[][] result = new int[ROW_NUMBER * factor][COLUMN_NUMBER * factor];

        for (int row = 0; row < array.length; row++) {

            int[] magnifiedRow = new int[COLUMN_NUMBER * factor];

            for (int column = 0; column < array[row].length; column++) {

                for (int i = 0; i < factor; i++) {
                    magnifiedRow[column * factor + i] = array[row][column];
                }


            }

            for (int i = 0; i < factor; i++) {
                result[row * factor + i] = magnifiedRow;
            }

        }

        return result;


    }

    private static void printMatrix(int[][] matrix){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }
    }
}
