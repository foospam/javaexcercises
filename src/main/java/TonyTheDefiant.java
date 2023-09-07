public class TonyTheDefiant {

    public static void main(String[] args) {
        System.out.print("QUESTION: ");
        String question = new java.util.Scanner(System.in).nextLine();
        answerQuestions(question);

    }

    public static void answerQuestions(String question){
        System.out.print("ANSWER: ");
        if (question.endsWith("No idea?")) System.out.println("Aye!");
        else if (question.endsWith("?")) System.out.println(question+" No idea!");
        else System.out.println("...");
    }
}
