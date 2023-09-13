public class UnaryCoding {
    public static void main(String[] args) {
        System.out.println(encode(0, 1, 2, 3, 0, 1));
        System.out.println(encode(0, 0, 0, 0));
        encode();
        System.out.println(decode("0101101110010"));
        int[] numbers = decode("0101101110010");
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
        System.out.println(numbers[3]);
        System.out.println(numbers[4]);
        System.out.println(numbers[5]);

    }

    private static String encode(int... ints){
        StringBuilder stringBuilder = new StringBuilder();
        for (int integer : ints){
            stringBuilder.append("1".repeat(integer)).append(0);
        }
        return stringBuilder.toString();
    }

    private static int[] decode(String value){

        int zeroCounter = 0;

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '0') zeroCounter++;
        }

        int[] result = new int[zeroCounter];

        int j=0;
        for (int i = 0; j < result.length && i < value.length(); i++) {
            if (value.charAt(i) == '1') result[j]++;
            else j++;
        }


        return result;

    }

}
