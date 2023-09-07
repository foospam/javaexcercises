public class PalindromeTester {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ababa"));
        System.out.println(isPalindrome("abaBa"));
        System.out.println(isPalindromeIgnoringCase("abaBa"));
        System.out.println(isPalindromeIgnoringNonLettersAndDigits("A man a plan a canal Panama"));
        System.out.println(isPalindromeIgnoringNonLettersAndDigits("Pepe in Tahiti hat nie Pep"));
        System.out.println(isPalindromeIgnoringNonLettersAndDigits("Sei fies – stets sei fies!"));

    }

    private static boolean isPalindrome(String s){

        int MIDDLE = s.length()/2;
        for (int left = 0, right = s.length()-1; left < MIDDLE; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }

    private static boolean isPalindromeIgnoringCase(String s){

        String sLower = s.toLowerCase();
        return isPalindrome(sLower);
    }

    private static boolean isPalindromeIgnoringNonLettersAndDigits(String s){

        String sLettersDigits = removeSpecialCharacters(s);
        return isPalindromeIgnoringCase(sLettersDigits);
    }

    private static String removeSpecialCharacters(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) result += c;
        }

        return result;

    }
}
