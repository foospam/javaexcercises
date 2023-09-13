public class PrintUnderLine {
    public static void main(String[] args) {
        String text = "There is more treasure in books than in all the pirates' loot on Treasure Island";
        System.out.println(printUnderLine(text, "treasure"));
    }

    private static String printUnderLine(String string, String search) {
        StringBuilder stringBuilder = new StringBuilder(" ".repeat(string.length()));

        String lowerCaseString = string.toLowerCase();
        String lowerCaseSearch = search.toLowerCase();

        int searchLength = search.length();
        int searchIndex = lowerCaseString.indexOf(lowerCaseSearch);
        System.out.println(searchIndex);
        while (searchIndex != -1) {
            stringBuilder.replace(searchIndex, searchIndex + searchLength, "-".repeat(searchLength));
            searchIndex = lowerCaseString.indexOf(lowerCaseSearch, searchIndex+searchLength);
        }

        stringBuilder.insert(0, "\n");
        stringBuilder.insert(0, string);

        return stringBuilder.toString();
    }

}
