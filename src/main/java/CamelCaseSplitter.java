public class CamelCaseSplitter {
    public static void main(String[] args) {
        System.out.println(camelCaseSplitter("estoEsUnTextoESCRITOenCamelCase"));

    }

    private static String camelCaseSplitter(String camelCaseString){
        StringBuilder stringBuilder = new StringBuilder(camelCaseString);

        for (int i = stringBuilder.length()-1; i > 0; i--) {
            if ((stringBuilder.charAt(i) <= 'Z' && stringBuilder.charAt(i-1) > 'Z'))
                stringBuilder.insert(i, ' ');
            else if ((i >= 2 && stringBuilder.charAt(i) > 'Z' &&
                    stringBuilder.charAt(i-1) <= 'Z' && stringBuilder.charAt(i-2) <= 'Z'))
                stringBuilder.insert(i, ' ');
        }

        return stringBuilder.toString();
    }
}
