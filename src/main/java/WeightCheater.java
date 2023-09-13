public class WeightCheater {
    public static void main(String[] args) {
        System.out.println(cheatedWeight(5414951));

    }

    private static int cheatedWeight(int weight){
        StringBuilder weightString = new StringBuilder(String.valueOf(weight));

        int minValue = 9;
        int minValuePosition = weightString.length()-1;

        for(int i = minValuePosition; i > 0; i--){
            int c = Integer.parseInt(String.valueOf(weightString.charAt(i)));
            if (c < minValue) {
                minValue = c;
                minValuePosition = i;
                if (c == 1) break;
            }
        }

        System.out.println(weightString.length());
        char first = weightString.charAt(0);
        weightString.deleteCharAt(0);
        weightString.insert(0, minValue);
        weightString.deleteCharAt(minValuePosition);
        weightString.insert(minValuePosition, first);

        return Integer.parseInt(weightString.toString());

    }
}
