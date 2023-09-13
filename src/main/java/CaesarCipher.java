public class CaesarCipher {
    public static void main(String[] args) {
        String text = "Vini vidi vinci";
        System.out.println(caesar(text, 101));
        System.out.println(decaesar(caesar(text, 40), 40));

    }

    private static String caesar(String string, int rotation){
        StringBuilder stringBuilder = new StringBuilder(string.length());

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                stringBuilder.append((char) ((c - 'A' + rotation) % 25 + 'A'));
            }
            else if (c >= 'a' && c <= 'z') {
                stringBuilder.append((char) ((c - 'a' + rotation) % 25 + 'a'));
            }
            else stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static String decaesar(String string, int rotation){
        StringBuilder stringBuilder = new StringBuilder(string.length());

        rotation %= 25;
        /** Without this, the +25 correction in the for loop is useless (you get negative values from the inner
         * operation (c - 'A' - rotation + 25), so that the modulo division gets a negative result.
         */

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                stringBuilder.append((char) ((c - 'A' - rotation + 25) % 25 + 'A'));
            }
            else if (c >= 'a' && c <= 'z') {
                stringBuilder.append((char) ((c - 'a' - rotation + 25) % 25 + 'a'));
            }
            else stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
