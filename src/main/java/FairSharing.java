public class FairSharing {
    public static void main(String[] args) {
        int[] values = { 10, 20, 30, 40, 40, 50 };
        System.out.println(findSplitPoint(values));


    }

    private static int findSplitPoint(int[] intArray) {

        int leftCursor = 0;
        int rightCursor = intArray.length - 1;

        int leftSum = intArray[leftCursor]; // Initializes sum values from left and right
        int rightSum = intArray[rightCursor];

        while (leftCursor != rightCursor) {
            if (leftSum <= rightSum) {
                leftCursor++;
                if (leftCursor != rightCursor) leftSum += intArray[leftCursor];

            } else if (rightSum < leftSum) {
                rightCursor--;
                if (leftCursor != rightCursor) rightSum += intArray[rightCursor];
            }
        }

        if (relativeDifference(leftSum, rightSum) <= 10) return leftCursor+1;
        else return -1;
    }

    private static int relativeDifference(int a, int b) {
        if (a == b) return 0;
        int absoluteDifference = Math.abs(a - b);
        return (int) (100. * absoluteDifference / Math.max(a, b));
    }
}
