package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.QUESTION_AND_ANSWERS_COLUMNS;
import static hexlet.code.Engine.QUESTION_AND_ANSWERS_ROWS;

public class Gcd {

    private static final String DESCRIPTION_GAME = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER = 50;

    private static int gcd(int firstNumber, int secondNumber) {
        int result = 0;
        int counter = 1;
        while (counter <= firstNumber && counter <= secondNumber) {
            if (firstNumber % counter == 0 && secondNumber % counter == 0) {
                result = counter;
            }
            counter++;
        }
        return result;
    }

    public static void start() {
        String[][] questionAndAnswers = new String[QUESTION_AND_ANSWERS_ROWS][QUESTION_AND_ANSWERS_COLUMNS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstNumber = Utils.generateRandomNumber(MAX_NUMBER);
            int secondNumber = Utils.generateRandomNumber(MAX_NUMBER);
            int result = gcd(firstNumber, secondNumber);
            String question = firstNumber + " " + secondNumber;
            questionAndAnswers[0][i] = question;
            questionAndAnswers[1][i] = String.valueOf(result);
        }
        Engine.startGame(DESCRIPTION_GAME, questionAndAnswers);
    }
}
