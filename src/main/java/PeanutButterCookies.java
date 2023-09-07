public class PeanutButterCookies {
    public static void main(String[] args) {
        System.out.println(howManyCanBake("PSESEPESP"));
        System.out.println(howManyCanBake("PPPEEESSS"));
        System.out.println(howManyCanBake("SEPEPLSEE"));
    }

    private static int howManyCanBake(String ingredients){

        int COOKS = ingredients.length()/3;
        int result = 0;

        for (int i = 0; i < COOKS; i++) {

            String cook = ingredients.substring(i*3, i*3+3);
            if ((cook.contains("P") && cook.contains("E") && cook.contains("S"))) result++;
        }

        return result;
    }
}
