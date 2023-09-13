public class ChocolateCovered {
    public static void main(String[] args) {

        System.out.println(checkChocolate("dhFhd"));
        System.out.println(checkChocolate("ddhFh"));
        System.out.println(checkChocolate("ddhh"));
        System.out.println(checkChocolate("hdFdh"));
        System.out.println(checkChocolate(""));

        String fruit =
                "ddddd\n" +
                        "dhhhd\n" +
                        "dhFhd\n" +
                        "dhhhd\n" +
                        "ddddd" ;

        System.out.println(checkChocolate(fruit));

    }

    private static boolean checkChocolate(String fruitStick, int layer){

        if (fruitStick.equals("F") && layer != 0) return true;
        else if (fruitStick.length() == 0 ) return false;
        else if (fruitStick.charAt(0) == fruitStick.charAt(fruitStick.length()-1) &&
                (fruitStick.charAt(0) == 'd' || fruitStick.charAt(0) == 'h')) {
            return checkChocolate(fruitStick.substring(1, fruitStick.length()-1), ++layer);
        }
        else return false;
    }

    private static boolean checkChocolate(String fruitStick){

        if (fruitStick.contains("\n")) {
            fruitStick = fruitStick.replace("\n", "");
            return checkChocolate(fruitStick);
        }
        // I place this substitution here instead of in the complete checkChocolate method so that the condition
        // is only checked once, which optimizes the process.

        return checkChocolate(fruitStick, 0);
    }

    private static String removeNewLineChars(String fruitStick){
        return fruitStick.replace("\n", "");
    }
}
