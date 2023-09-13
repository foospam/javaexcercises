public class WordWrap {
    public static void main(String[] args) {

        String s = "LLives now; make now always thea most precious time. "
                + "Now will never come aga.";
        System.out.println(s.length());
        System.out.println( wrap( s, 15 ) );
    }

    private static String wrap(String text, int width) {
        int LEN = text.length();
        StringBuilder result = new StringBuilder(text);

        for (int i = 0, j = 0; i < LEN; i = j) {

            j = i + Math.min(width+1, LEN - i -1);

            if (j - i <= width) break; // If the last line fits the width, don't do anything else.
            char c = text.charAt(j);
            while (!Character.isSpaceChar(c)) {
                j--;
                c = text.charAt(j);
            }

            result.replace(j, j+1, "\n");
            if (LEN - j <=  width) break; // This is the ultimate stop condition.



        }
        return result.toString();
    }
}
