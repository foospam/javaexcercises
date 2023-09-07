public class StringUtils {
    public static void main(String[] args) {

        System.out.println(countMatches("ab", "ab"));
        System.out.println(countMatches("ababaasfsfasfaoab", "ab"));
        System.out.println(countMatches("abacbab", "ac"));
        System.out.println(countMatches("ababab", "abbabababa"));
        System.out.println(countMatches(null, "ab"));
        System.out.println(countMatches("ababab", null));
        System.out.println(countMatches("", "ab"));

    }

    /**
     * Counts how many times the substring appears in the larger string.
     *
     * A {@code null} or empty ("") String input returns {@code 0}.
     *
     * <pre>
     * StringUtils.countMatches(null, *)       = 0
     * StringUtils.countMatches("", *)         = 0
     * StringUtils.countMatches("abba", null)  = 0
     * StringUtils.countMatches("abba", "")    = 0
     * StringUtils.countMatches("abba", "a")   = 2
     * StringUtils.countMatches("aaaa", "aa")  = 2
     * StringUtils.countMatches("abba", "ab")  = 1
     * StringUtils.countMatches("abba", "xxx") = 0
     * </pre>
     *
     * @param string  the String to check, may be null
     * @param other   the substring to count, may be null
     * @return the number of occurrences, 0 if either String is {@code null}
     */
    public static int countMatches( String string, String other ) {

        if (string == null || other == null ||
                string.isEmpty() || other.isEmpty() ||
                string.length() < other.length()) return 0;

        int lenString = string.length();
        int lenOther = other.length();
        int count = 0;

        for (int i = 0; i < lenString; i++) {
            int index = string.indexOf(other, i);
            if (index >= 0) {
                count++;
                i += index + lenOther -1;
            }
        }

        return count;
    }
}
