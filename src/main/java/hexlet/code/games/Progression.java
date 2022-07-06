package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.QUESTION_AND_ANSWERS_COLUMNS;
import static hexlet.code.Engine.QUESTION_AND_ANSWERS_ROWS;


public class Progression {

    private static final String DESCRIPTION_GAME = "What number is missing in the progression?";
    private static final int MIN_LENGTH_PROGRESSION = 5;
    private static final int MAX_LENGTH_PROGRESSION = 10;
    private static final int MAX_STEP_PROGRESSION = 15;
    private static final int RESULT_PROGRESSION_LENGTH = 2;

    private static String[] progression(int firstElement, int step, int progressionLength, int indexHiddenElement) {
        StringBuilder progression = new StringBuilder();
        String[] result = new String[RESULT_PROGRESSION_LENGTH];
        int element = firstElement;
        String hiddenElement = null;
        for (int i = 0; i < progressionLength; i++) {
            if (i == indexHiddenElement) {
                hiddenElement = String.valueOf(element);
                progression.append("..").append(" ");
            } else {
                progression.append(element).append(" ");
            }
            element += step;
        }
        result[0] = progression.toString();
        result[1] = hiddenElement;
        return result;
    }

    public static void start() {
        String[][] questionsAndAnswers = new String[QUESTION_AND_ANSWERS_ROWS][QUESTION_AND_ANSWERS_COLUMNS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstElement = Utils.generateRandomNumber(Engine.MAX_NUMBER);
            int step = Utils.generateRandomNumber(MAX_STEP_PROGRESSION);
            int progressionLength = Utils.generateRandomNumber(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
            int indexHiddenElement = Utils.generateRandomNumber(progressionLength);
            String[] progression = progression(firstElement, step, progressionLength, indexHiddenElement);
            questionsAndAnswers[0][i] = progression[0];
            questionsAndAnswers[1][i] = progression[1];
        }
        Engine.startGame(DESCRIPTION_GAME, questionsAndAnswers);
    }
}
