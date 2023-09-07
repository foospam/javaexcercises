public class CrewSize {
    public static void main(String[] args) {
        compareCrews("|-|||");
        compareCrews("|-||");
        compareCrews("|||-|||");
        compareCrews("|||||-||");
    }

    private static void compareCrews(String logEntry){

        String[] crews = logEntry.split("-");
        java.util.Arrays.toString(crews);
        int difference = crews[0].length() - crews[1].length();
        if (difference > 0) System.out.printf("Pirate ship had a larger crew, difference %d%n", difference);
        else if (difference < 0) System.out.printf("Raided ship had a larger crew, difference %d%n", Math.abs(difference));
        else System.out.println("Ships had the same crew size");

    }
}
