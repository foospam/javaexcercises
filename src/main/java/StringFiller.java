public class StringFiller {
    public static void main(String[] args) {
        String texto = "Esto es un texto de prueba.";
        System.out.println(mix(texto, "-"));

    }

    private static String mix(String string, String separator){
        StringBuilder stringBuilder = new StringBuilder(string.length()*2);

        stringBuilder.append(string.charAt(0));

        for (int i = 1; i < string.length(); i++) {
            stringBuilder.append(separator);
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }
}
