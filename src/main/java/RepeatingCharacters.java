public class RepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(isEveryCharacterTwice("eehhrrwwüürrddiiggeerr$$ccaappttaaiinn"));
        System.out.println(isEveryCharacterTwice("ccapptttaaiinn"));
        System.out.println(isEveryCharacterTwice("222"));
        System.out.println(isEveryCharacterTwice(null));

    }

    private static int isEveryCharacterTwice(String string) throws NullPointerException, IllegalArgumentException {

        if (string == null) throw new NullPointerException("The input string is null!");
        if (string.isEmpty()) throw new IllegalArgumentException("The input must not be empty!");
        if (string.length() % 2 == 1) return 0;

        for (int i = 0; i < string.length(); i += 2) {
            if (!(string.charAt(i) == string.charAt(i + 1))) return -(i + 1);
        }

        return 1;
    }
}
