public class HtmlBuilder {
    public static void main(String[] args) {
        System.out.println(htmlElement("strong", "strong is bold"));
        System.out.println(strong(emphasized("strong + emphasized")));
        System.out.println(htmlElement("span", null));
        System.out.println(htmlElement("", "no"));
        System.out.println(htmlElement(null, "not strong"));
        System.out.println(htmlElement(null, null));

    }

    private static String htmlElement(String tag, String body) {
        String result;

        if (tag == null || tag.isEmpty()) {
            if (body == null || body.isEmpty()) result = "";
            else result = body;
        } else {
            if (body == null || body.isEmpty()) result = "<TAG_NAME></TAG_NAME>".replace("TAG_NAME", tag);
            else result = "<TAG_NAME>BODY_CONTENTS</TAG_NAME>"
                    .replace("TAG_NAME", tag)
                    .replace("BODY_CONTENTS", body);
        }

        return result;
    }

    private static String strong(String body) {
        return htmlElement("strong", body);
    }

    private static String emphasized(String body) {
        return htmlElement("em", body);
    }
}
