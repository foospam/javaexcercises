public class InMiddle {
    public static void main(String[] args) {
        System.out.println(isCiaoCiaoInMiddle("CiaoCiao"));
        System.out.println(isCiaoCiaoInMiddle("!CiaoCiao!"));
        System.out.println(isCiaoCiaoInMiddle("SupaCiaoCiaoCute"));
        System.out.println(isCiaoCiaoInMiddle("x!_CiaoCiaoabc"));
        System.out.println(isCiaoCiaoInMiddle("\tCiaoCiao "));
        System.out.println(isCiaoCiaoInMiddle("BambooCiaoCiaoBlop"));
        System.out.println(isCiaoCiaoInMiddle("Bernie und Ert"));
    }

    public static boolean isCiaoCiaoInMiddle(String s){
        if (s.length() % 2 != 0  || s.length() < 8) return false;
        int MIDDLE = s.length()/2;
        return s.substring(MIDDLE-4, MIDDLE+4).equals("CiaoCiao");
    }
}
