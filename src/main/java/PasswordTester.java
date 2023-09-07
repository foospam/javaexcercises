public class PasswordTester {

    private static final int MIN_LENGTH = 8;

    public static void main(String[] args) {
        System.out.println(isGoodPassword("A131aafB!!2"));
        System.out.println(isGoodPassword("A1B!!2"));

    }

    private static boolean isGoodPassword (String password) throws IllegalArgumentException {
        if (password == null) throw new IllegalArgumentException("The password cannot be null!");

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialCharacter = false;
        boolean longEnough = false;

        if (password.length() < MIN_LENGTH) {
            System.err.printf("The password must be at lease %d characters long!%n", MIN_LENGTH);
        }
        else longEnough = true;

        int len = password.length();
        for (int i = 0; i < len; i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) upperCase = true;
                else lowerCase = true;
            } else if (Character.isDigit(c)) digit = true;
            else specialCharacter = true;

        }

        if (!upperCase) System.err.println("The password must contain at least one uppercase letter!");
        if (!lowerCase) System.err.println("The password must contain at least one lowercase letter!");
        if (!digit) System.err.println("The password must contain at least one digit!");
        if (!specialCharacter) System.err.println("The password must contain at least one special character!");
        return upperCase && lowerCase && digit && specialCharacter && longEnough;
    }
}
