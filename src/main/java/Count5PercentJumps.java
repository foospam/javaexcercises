public class Count5PercentJumps {
    public static void main(String[] args) {

        int[] dailyGains  = { 1000, 2000, 500, 9000, 9010 };
        System.out.println(count5PercentJumps(dailyGains));
        dailyGains = null;
        System.out.println(count5PercentJumps(dailyGains));

    }
    private static int count5PercentJumps(int[] intArray) throws NullPointerException {
        if (intArray == null) throw new NullPointerException("The array is null!");

        int count = 0;
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] >= intArray[i-1] * 1.05) count++;
        }

        return count;
    }
}
