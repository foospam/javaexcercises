class RightTriangle {
    public static void main(String[] args) {

        System.out.println(isRightTriangle(3, 4, 5));
        System.out.println(isRightTriangle(5, 4, 3));
        System.out.println(isRightTriangle(5, 12, 13));
        System.out.println(isRightTriangle(1, 2, 3));
        System.out.println(isRightTriangle(1, 1, Math.sqrt(2)));

    }
    public static boolean isRightTriangle( double a, double b, double c ) {
        return (Math.pow(Math.max(a, Math.max(b,c)),2) * 2 ==
                Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2));
    }
}
