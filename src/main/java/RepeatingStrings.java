public class RepeatingStrings {
    public static void main(String[] args) {

        System.out.println(repeatingStrings("🌼🌼🌼"));
        System.out.println(repeatingStrings("🌼🌻"+"🌼🌻"+"🌼🌻"));
        System.out.println(repeatingStrings("Ciao" + "Ciao"));
        System.out.println(repeatingStrings("Captain CiaoCiaoCaptain CiaoCiao"));
        System.out.println(repeatingStrings("🌕🌔🌓🌑"));
        System.out.println(repeatingStrings("CaptainCiaoCiaoCaptain"));
        System.out.println(repeatingStrings("🌼"));
        System.out.println(repeatingStrings(""));
        System.out.println(repeatingStrings(null));

    }

    private static String repeatingStrings(String string){

        int LEN = string.length();
        int MIDDLE = string.length()/2;

        String pattern = null;

        for (int i = 1; i <= MIDDLE; i++) {
            if (LEN % i == 0) {
                String subString = string.substring(0, i);
                if (string.equals(subString.repeat(LEN / i))) {
                    pattern = subString;
                    break;
                }
            }
        }

        return pattern;
    }
}
