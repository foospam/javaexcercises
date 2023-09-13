public class Abcz {
    public static void main(String[] args) {
        abcz();
        System.out.println(abcz('Z', 'A'));
        System.out.println(abcz('A', 25));

    }

    private static void abcz() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append('A');
        for (int i = 'B'; i <= 'Z'; i++) {
            stringBuilder.append(' ').append((char) i);
        }
        System.out.println(stringBuilder.toString());
    }

    private static String abcz(char start, char end){
        StringBuilder stringBuilder = new StringBuilder();

        if(start > end) {
            char t = start;
            start = end;
            end = t;
        }

        stringBuilder.append((char) start);
        for (int i = start+1; i <= end; i++) {
            stringBuilder.append(' ').append((char) i);
        }
        return stringBuilder.toString();
    }

    private static String abcz(char start, int length){
        char end = (char) (start + length);
        return abcz(start, end);
    }
}
