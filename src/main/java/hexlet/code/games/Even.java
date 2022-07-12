package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.QUESTION_AND_ANSWERS_COLUMNS;
import static hexlet.code.Engine.QUESTION_AND_ANSWERS_ROWS;


public class Even {
    private static final String DESCRIPTION_GAME = "Answer 'yes' if number even otherwise answer 'no'.";

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    public static void start() {
        String[][] questionsAndAnswers = new String[QUESTION_AND_ANSWERS_ROWS][QUESTION_AND_ANSWERS_COLUMNS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int number = Utils.generateRandomNumber(Engine.MAX_NUMBER);
            boolean isEven = isEvenNumber(number);
            String answer = isEven ? "yes" : "no";
            questionsAndAnswers[0][i] = String.valueOf(number);
            questionsAndAnswers[1][i] = answer;
        }
        Engine.startGame(DESCRIPTION_GAME, questionsAndAnswers);
    }
}
