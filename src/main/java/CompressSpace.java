public class CompressSpace {
    public static void main(String[] args) {
        System.out.println(compressSpace(new StringBuilder("•\t\"Will   you shut up,  man!   This is the way!\"")));
    }

    private static StringBuilder compressSpace(StringBuilder string) {

        for (int i = string.length()-1; i > 0; i--) {
            if (string.charAt(i) == ' ' && string.charAt(i - 1) == ' ')
                string.deleteCharAt(i);
        }

        return string;
    }
}
