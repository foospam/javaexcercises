public class YZswapper {
    public static void main(String[] args) {
        printSwappedYZ("yootaxz");
        printSwappedYZ("Yanthoxzl");

        printSwappedYZ2("yootaxz");
        printSwappedYZ2("Yanthoxzl");
    }

    public static void printSwappedYZ(String string){
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            switch (c) {
                case 'y':
                    System.out.print('z');
                    break;
                case 'Y':
                    System.out.print('Z');
                    break;
                case 'z':
                    System.out.print('y');
                    break;
                case 'Z':
                    System.out.print('Y');
                    break;
                default:
                    System.out.print(c);
            }
        }
        System.out.println();
    }

    public static void printSwappedYZ2(String string){
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == 'y') System.out.print('z');
            else if (c == 'Y') System.out.print('Z');
            else if (c == 'z') System.out.print('y');
            else if (c == 'Z') System.out.print('Y');
            else System.out.print(c);
        }
        System.out.println();
    }
}
