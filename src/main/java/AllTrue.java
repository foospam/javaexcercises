public class AllTrue {
    public static void main(String[] args) {

        System.out.println(allTrue(true, true, true));
        System.out.println(allTrue(true));
        System.out.println(allTrue(true, false));
        //allTrue(true, null);
        //System.out.println(allTrue());

    }

    private static boolean allTrue(boolean value1, boolean... values){
        if (value1 == false) return false; /* In der Lösung gibt man am Ende den Wert value1 aus, wenn
        alle andere Werte true sind. Trotzdem können wir uns ersparen, den Array durchzugehen, wenn das
        erste Argument false ist. */

        for (boolean value : values) {
            if (value == false) return false;
        }

        return true; //
    }
}
