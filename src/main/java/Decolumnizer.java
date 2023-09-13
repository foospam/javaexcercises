import java.util.Arrays;

public class Decolumnizer {
    public static void main(String[] args) {
        String text = """
                I’m dishonest, and a to watch out for,
                dishonest man you    because you can
                can always trust to  never predict when
                be dishonest.        they’re going to do
                Honestly, it’s the   something incredibly
                honest ones you want stupid.
                """;

        System.out.println(decolumnize(text));

    }

    public static String decolumnize(String s){

        String left = "";
        String right = "";

        String[] strings = s.split("\n");
        int separator = findColumnSeparator(s);

        for (int i = 0; i < strings.length; i++) {
            String leftColumn = strings[i].substring(0, separator);
            String righColumn = strings[i].substring(separator+1);

            left += !leftColumn.isBlank() ? cleanLines(leftColumn) : "";
            right += !righColumn.isBlank() ? cleanLines(righColumn) : "";
        }

        return left+right;
    }

    public static int findColumnSeparator(String string) {

        String[] strings = string.split("\n");

        java.util.Stack<Integer> candidateStack = new java.util.Stack<Integer>();

        String firstLine = strings[0];

        firstDimension:
        for (int i = 0; i < firstLine.length(); i++){
            if (firstLine.charAt(i) == ' ') {
                // System.out.println("Whitespace found at "+i);
                int candidate = i; // Candidates for column separators are whitespaces which are present in every line

                for (int j = 1; j < strings.length; j++) {
                    // System.out.printf("Line %d inspected for column %d%n", j, candidate);
                    if (strings[j].length() <= i) continue;
                    else if (strings[j].charAt(candidate) != ' ') continue firstDimension;
                    // else System.out.printf("Whitspace found in line %d column %d %n", j, candidate);
                }

                candidateStack.push(candidate);
            }
        }

        if (candidateStack.size() == 1) return candidateStack.pop();
        else if (candidateStack.size() == 0) return -1;
        else {
            int[] candidateArray = new int[candidateStack.size()];
            return candidateArray[candidateArray.length/2];
        }
    }

    private static String cleanLines(String line){
        line = line.strip();
        line += "\n";
        return line;
    }
}
