import java.util.Optional;

public class Flowers {

    static final String FLOWER_SOURCE = """
                            _                                        \s
                          _(_)_                          wWWWw   _   \s
              @@@@       (_)@(_)   vVVVv     _     @@@@  (___) _(_)_ \s
             @@()@@ wWWWw  (_)\\    (___)   _(_)_  @@()@@   Y  (_)@(_)\s
              @@@@  (___)     `|/    Y    (_)@(_)  @@@@   \\|/   (_)\\ \s
               /      Y       \\|    \\|/    /(_)    \\|      |/      | \s
            \\ |     \\ |/       | / \\ | /  \\|/       |/    \\|      \\|/\s
            \\\\|//   \\\\|//   \\\\\\|//\\\\\\|/// \\|///  \\\\\\|//  \\\\|//  \\\\\\|//
            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^""";



    static final int FLOWER_SOURCE_LEN = 58;
    static final int[] FLOWER_INDEX = new int[]{0, 7, 13, 22, 29, 37, 44, 50, 58};
    static final int FLOWER_HEIGHT = 8;
    static final int FLOWER_NUMBER = 8;

    public static void main(String[] args) {
        printFlowers("1234123789B");
    }

    private static void printFlowers(String flowerSeq){

        for (int ROW = 0; ROW < FLOWER_HEIGHT; ROW++) {
            for (int i = 0; i < flowerSeq.length(); i++){
                char c = flowerSeq.charAt(i);
                int flower_lookup;
                if (Character.isDigit(c) && Character.getNumericValue(c) <= FLOWER_NUMBER)
                    flower_lookup = Character.getNumericValue(c) -1;
                else flower_lookup = 0;

                int flower_start = FLOWER_INDEX[flower_lookup];
                int flower_end = FLOWER_INDEX[flower_lookup + 1];

                //System.out.println(flower_start+ " "+flower_end);

                for (int column = flower_start; column < flower_end; column++) {
                    System.out.print(FLOWER_SOURCE.charAt(FLOWER_SOURCE_LEN * ROW + column + ROW));
                    // + ROW is an additional offset accounting for the linebreaks
                }
            }
            System.out.println();
        }
    }
}
