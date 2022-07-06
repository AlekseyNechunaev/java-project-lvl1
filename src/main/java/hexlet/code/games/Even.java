package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.QUESTION_AND_ANSWERS_COLUMNS;
import static hexlet.code.Engine.QUESTION_AND_ANSWERS_ROWS;

public class Even {
    private static final String DESCRIPTION_GAME = "Answer 'yes' if number even otherwise answer 'no'.";
    private static final int MAX_NUMBER = 100;

    private static String isEvenNumber(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    public static void start() {
        String[][] questionsAndAnswers = new String[QUESTION_AND_ANSWERS_ROWS][QUESTION_AND_ANSWERS_COLUMNS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int number = Utils.generateRandomNumber(MAX_NUMBER);
            String isEvenResult = isEvenNumber(number);
            questionsAndAnswers[0][i] = Integer.toString(number);
            questionsAndAnswers[1][i] = isEvenResult;
        }
        Engine.startGame(DESCRIPTION_GAME, questionsAndAnswers);
    }
}
