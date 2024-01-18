public class DiceGame {
    public static void main(String[] args) {

        int[] dice = shuffleDice();
        printDice(dice);
        printDiceValues(dice);
        System.out.println(isFullHouse(new int[]{2,1,3,3,3}));
        System.out.println(isHomogeneous(new int[]{2,2,2,2,2}));

    }

    private static int[] shuffleDice() {

        int[] dice = new int[5];
        for (int i = 0; i < 5; i++) {
            dice[i] = (int) (Math.random() * 6) + 1;
        }
        return dice;
    }

    private static void printDice(int[] dice) {
        for (int i = 0; i <= dice.length - 1; i++) {
            System.out.printf("%d%s", dice[i], i != dice.length - 1 ? " - " : "\n");
        }
    }

    private static boolean isHomogeneous(int[] values) {
        boolean result = true;
        int firstValue = values[0];
        for (int value : values) {
            if (value != firstValue) return false;
        }

        return result;
    }

    private static int[] occurrences(int[] dice) {
        int[] values = new int[6];
        for (int die : dice) {
            values[die - 1]++;
        }
        return values;
    }

    private static boolean isFullHouse(int[] dice) {
        int[] values = occurrences(dice);
        boolean pair = false;
        boolean triple = false;

        for (int value : values) {
            if (value == 2) pair = true;
            else if (value == 3) triple = true;
        }

        return pair && triple;
    }

    private static void printDiceValues(int[] dice) {
        char[] FACE_VALUES = new char[]{'\u2680',
                '\u2681', '\u2682', '\u2683', '\u2684', '\u2685'};

        int[] values = occurrences(dice);

        for (int i = 0; i < values.length; i++) {
            if (values[i] != 0) {
                System.out.printf("%d x %c%s", values[i], FACE_VALUES[i], i < values.length - 1 ? ", " : "");
            }

        }
        System.out.println();

    }

}
