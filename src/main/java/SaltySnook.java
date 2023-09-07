public class SaltySnook {

    public static void main(String[] args) {
        String[] signs1 = {"F", "DO", "MOS", "MOS", "MOS", "MOS", "WES"};
        System.out.println(isProbablyApproaching(signs1));   // true

        String[] signs2 = {"F", "DO", "MOS", "MOS", "WES", "MOS", "MOS"};
        System.out.println(isProbablyApproaching(signs2));  // false

        String[] signs3 = {"F", "DO", null, "MOS", "WES", "MOS", "MOS"};
        System.out.println(isProbablyApproaching(signs3));  // exception

    }

    private static boolean isProbablyApproaching(String[] signs) throws NullPointerException {
        final int MIN_OCCURRENCIES = 4;

        if (signs == null) throw new NullPointerException("The array must nut be null!");
        if (signs.length < MIN_OCCURRENCIES) return false;

        for (int i = 0; i < signs.length; i++) {
            if (signs[i] == null) throw new NullPointerException("The array must not contain any null values! " +
                    "Null value found at index " + i);
        }


        int consecutiveSignCounter = 1;

        for (int i = 1; i < signs.length; i++) {
            String currentSign = signs[i];
            String lastSign = signs[i - 1];
            if (currentSign.equals(lastSign)) {
                consecutiveSignCounter++;
                if (consecutiveSignCounter == MIN_OCCURRENCIES) return true;
            } else consecutiveSignCounter = 1;
        }

        return false;
    }
}
