public class CisterNumbers {

    public static void main(String[] args) {
        System.out.println("Please enter a number:");
        int number = new java.util.Scanner(System.in).nextInt();
        System.out.println("Please enter a stroke length:");
        int stroke_length = new java.util.Scanner(System.in).nextInt();
        System.out.println("Here is your number:\n\n");
        printNumber(number, stroke_length);

    }

    static int[] getA(int pos, int stroke_length){
        switch (pos){
            case 0:
            case 1:
                return new int[]{stroke_length, 0};
            case 2:
            case 3:
                return new int[]{stroke_length, stroke_length*3};
        }
        return new int[]{};
    }

    static int[] getB(int pos, int stroke_length){
        switch (pos){
            case 0:
                return new int[]{stroke_length * 2, 0};
            case 1:
                return new int[]{0, 0};
            case 2:
                return new int[]{stroke_length *2, stroke_length * 3};
            case 3:
                return new int[]{0, stroke_length * 3};
        }
        return new int[]{};
    }

    static int[] getC(int pos, int stroke_length){
        switch (pos){
            case 0:
            case 1:
                return new int[]{stroke_length, stroke_length};
            case 2:
            case 3:
                return new int[]{stroke_length, stroke_length*2};
        }
        return new int[]{};
    }

    static int[] getD(int pos, int stroke_length){
        switch (pos){
            case 0:
                return new int[]{stroke_length*2, stroke_length};
            case 1:
                return new int[]{0, stroke_length};
            case 2:
                return new int[]{stroke_length*2, stroke_length*2};
            case 3:
                return new int[]{0, stroke_length*2};
        }
        return new int[]{};
    }

    static int[] diagonalUp(int stroke_length, int pos){
        int[] a = getC(pos, stroke_length);
        int[] b = getB(pos, stroke_length);

        return new int[]{a[0], a[1], b[0], b[1]};
    }

    static int[] diagonalDown(int stroke_length, int pos){
        int[] a = getA(pos, stroke_length);
        int[] b = getD(pos, stroke_length);

        return new int[]{a[0], a[1], b[0], b[1]};
    }

    static int[] upperHorizontal(int stroke_length, int pos){
        int[] a = getA(pos, stroke_length);
        int[] b = getB(pos, stroke_length);

        return new int[]{a[0], a[1], b[0], b[1]};
    }

    static int[] lowerHorizontal(int stroke_length, int pos){
        int[] a = getC(pos, stroke_length);
        int[] b = getD(pos, stroke_length);

        return new int[]{a[0], a[1], b[0], b[1]};
    }

    static int[] vertical(int stroke_length, int pos){
        int[] a = getB(pos, stroke_length);
        int[] b = getD(pos, stroke_length);

        return new int[]{a[0], a[1], b[0], b[1]};
    }

    static int[] divider(int stroke_length){
        return new int[]{stroke_length, 0, stroke_length, stroke_length*3};
    }


    static void printStroke(int[] stroke){
        System.out.printf("<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke-width=\"2\" stroke=\"black\"/>%n",
                stroke[0], stroke[1], stroke[2], stroke[3]);
    }

    static void printDigit(int digit, int strokeLength, int pos){
        switch (digit) {
            case 1:
                printStroke(upperHorizontal(strokeLength, pos));
                break;
            case 2:
                printStroke(lowerHorizontal(strokeLength, pos));
                break;
            case 3:
                printStroke(diagonalDown(strokeLength, pos));
                break;
            case 4:
                printStroke(diagonalUp(strokeLength, pos));
                break;
            case 5:
                printStroke(upperHorizontal(strokeLength, pos));
                printStroke(diagonalUp(strokeLength, pos));
                break;
            case 6:
                printStroke(vertical(strokeLength, pos));
                break;
            case 7:
                printStroke(upperHorizontal(strokeLength, pos));
                printStroke(vertical(strokeLength, pos));
                break;
            case 8:
                printStroke(lowerHorizontal(strokeLength, pos));
                printStroke(vertical(strokeLength, pos));
                break;
            case 9:
                printStroke(upperHorizontal(strokeLength, pos));
                printStroke(lowerHorizontal(strokeLength, pos));
                printStroke(vertical(strokeLength, pos));
                break;
            default:
                break;
        }
    }

    static void printNumber(int number, int strokeLength){

        startSVG(strokeLength);
        printStroke(divider(strokeLength));

        for (int i = 0; i < 4; i++) {
            int digit = number % 10;
            number /= 10;
            printDigit(digit, strokeLength, i);
        }

        endSVG();
    }


    static void startSVG(int strokeLength){
        System.out.printf("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<svg width=\"%d\" height=\"%d\">",
                strokeLength*2 + 5,
                strokeLength*3 + 5);
    }

    static void endSVG(){
        System.out.println("</svg>\n" +
                "</body>\n" +
                "</html>");
    }
}
