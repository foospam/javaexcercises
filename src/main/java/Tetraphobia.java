import java.util.Stack;

public class Tetraphobia {
    public static void main(String[] args) {

        int[] numberList = new int[]{3,4,5,6,14,3,1,5,43,154,231,876};
        printArray(numberList);
        fourLast(numberList);
        printArray(numberList);
    }

    private static void fourLast(int... numbers){
        Stack stack_1 = new Stack<Integer>();
        Stack stack_2 = new Stack<Integer>();

        for (int number : numbers) {
            if (containsFour(number)) stack_2.push(number);
            else stack_1.push(number);
        }

        for (int i = numbers.length-1 ; i >= 0 ; i--) {
            if (stack_2.empty()) numbers[i] = (int) stack_1.pop();
            else numbers[i] = (int) stack_2.pop();
        }
    }

    private static boolean containsFour(int number) {

        for (; number > 0 ; number /= 10) {
            if (number % 10 == 4) return true;
        }
        return false;
    }

    private static void printArray( int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", (int) array[i]);
        }
        System.out.println();
    }
}
