import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Crack {
    public static void main(String[] args) {
        String message = "Esto es un mensaje para que se llene de puras interferencias.";
        String message2;
        System.out.println(message2 = crackle(message));
        System.out.println(message2 = decrackle(message2));

    }

    public static final String CRACK = "♬CRACK♪";

    public static String crackle(String message){
        StringBuilder stringBuilder = new StringBuilder(message);

        for (int i = stringBuilder.length()-1; i >= 0; i--) {
            if (Math.random() < 0.05) {
                stringBuilder.insert(i, CRACK);
            }
        }

        return stringBuilder.toString();
    }

    public static String decrackle(String message){
        StringBuilder stringBuilder = new StringBuilder(message);

        int a = stringBuilder.lastIndexOf(CRACK);
        while(a != -1){
            stringBuilder.delete(a, a+CRACK.length());
            a = stringBuilder.lastIndexOf(CRACK);
        }

        /**
         * FRAGE AN CHRISTIAN: Ist diese code-Duplizierung ok?
         */
        return stringBuilder.toString();
    }
}
