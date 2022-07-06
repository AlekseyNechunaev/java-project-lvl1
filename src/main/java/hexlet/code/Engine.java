package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int ROUNDS = 3;
    public static final int QUESTION_AND_ANSWERS_ROWS = 2;
    public static final int QUESTION_AND_ANSWERS_COLUMNS = 3;
    public static final int MAX_NUMBER = 100;

    public static void startGame(String gameDescription, String[][] questionsAndAnswers) {
        String playerName = Cli.greet();
        Scanner reader = new Scanner(System.in);
        System.out.println(gameDescription);
        for (int i = 0; i < ROUNDS; i++) {
            System.out.println("Question: " + questionsAndAnswers[0][i]);
            String userAnswer = reader.nextLine();
            System.out.println("Your answer: " + userAnswer);
            String expectedResult = questionsAndAnswers[1][i];
            if (!questionsAndAnswers[1][i].equalsIgnoreCase(userAnswer)) {
                System.out.print("'" + userAnswer + "' is wrong answer ;(");
                System.out.println(". Correct answer was" + "'" + expectedResult + "'");
                System.out.println("Let's try again, " + playerName + "!");
                System.exit(0);
            } else {
                System.out.println("Correct!");
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
