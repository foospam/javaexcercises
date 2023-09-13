public class RemoveVowels {
    public static void main(String[] args) {
        System.out.println(removeVowels("esto es una prueba"));
        System.out.println(removeVowels2("Esto es otra prueba con äöü"));

    }

    public static String removeVowels(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);

        for (int i = stringBuilder.length() - 1; i >= 0; i--) {
            switch (stringBuilder.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'ü',
                        'A', 'E', 'I', 'O', 'U', 'Ä', 'Ö', 'Ü':
                    stringBuilder.deleteCharAt(i);
                default:
                    break;
            };
        }

        return stringBuilder.toString();
    }

    public static String removeVowels2(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        char c;
        for (int i = 0; i < string.length(); i++) {
            switch (c = string.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'ü',
                        'A', 'E', 'I', 'O', 'U', 'Ä', 'Ö', 'Ü':
                    break;
                default:
                    stringBuilder.append(c);
            };
        }
        return stringBuilder.toString();
    }

    /**
     * FRAGE AN CHRISTIAN: Wenn wir das mit einem enhanced switch gemacht hätten, hätte
     * sich ein zusätzliches Objekt des Typs stringBuilder irgendwo im Nichts erzeugt?
     */
}
