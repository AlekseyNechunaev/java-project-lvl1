package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.QUESTION_AND_ANSWERS_COLUMNS;
import static hexlet.code.Engine.QUESTION_AND_ANSWERS_ROWS;

public class Prime {

    private static final String DESCRIPTION_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static String isPrime(int number) {
        if (number < 2) {
            return "no";
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }

    public static void start() {
        String[][] questionsAndAnswers = new String[QUESTION_AND_ANSWERS_ROWS][QUESTION_AND_ANSWERS_COLUMNS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int number = Utils.generateRandomNumber(Engine.MAX_NUMBER);
            String answer = isPrime(number);
            questionsAndAnswers[0][i] = String.valueOf(number);
            questionsAndAnswers[1][i] = answer;
        }
        Engine.startGame(DESCRIPTION_GAME, questionsAndAnswers);
    }

}
