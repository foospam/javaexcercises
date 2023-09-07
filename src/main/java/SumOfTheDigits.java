public class SumOfTheDigits {
    public static void main(String[] args) {
        System.out.println(digitSum(1024));
        System.out.println(digitSum("1024"));

    }

    private static int digitSum(long value){
        if (value < 10) return (int) value;
        int result = 0;
        for (; value > 0; value /= 10) {
            result += value % 10;
        }

        return result;
    }

    private static int digitSum(String value){
        long valueLong = Long.valueOf(value);
        return digitSum(valueLong);
    }
}
