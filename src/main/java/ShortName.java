public class ShortName {
    public static void main(String[] args) {
        System.out.println(shortestName("Albert Tross", "Blowfish", "Nick Olaus", "Jo Ker"));

    }

    private static String shortestName(String... args){
        if (args == null) throw new NullPointerException("Enter at last one name!");
        else if (args.length == 0) return "";

        int shortestLen = Integer.MAX_VALUE;
        String shortestName = "";

        for (String string : args) {
            for (String name : string.split(" ")) {
                if (name.length() < shortestLen) {
                    shortestLen = name.length();
                    shortestName = name;
                }
            }
        }

        return shortestName;
    }
}
