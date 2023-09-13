public class Messenger {
    public static void main(String[] args) {
        System.out.println(joinSplitMessages("Hoy", "ok"));
        System.out.println(joinSplitMessages("Hooky"));
        System.out.println(joinSplitMessages("Hk", "oy", "o"));
        System.out.println(joinSplitMessages("H", "", "ooky"));

    }

    private static String joinSplitMessages(String... messages) {

        StringBuilder fullMessage = new StringBuilder();

        int maxLength = 0;
        for (String message : messages) {
            maxLength = Math.max(maxLength, message.length());
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < messages.length; j++) {
                if (i < messages[j].length()) fullMessage.append(messages[j].charAt(i));
            }
        }

        return fullMessage.toString();
    }
}
