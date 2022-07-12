package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.QUESTION_AND_ANSWERS_COLUMNS;
import static hexlet.code.Engine.QUESTION_AND_ANSWERS_ROWS;


public class Progression {

    private static final String DESCRIPTION_GAME = "What number is missing in the progression?";
    private static final int MIN_LENGTH_PROGRESSION = 5;
    private static final int MAX_LENGTH_PROGRESSION = 10;

    private static final int MIN_STEP_PROGRESSION = 1;
    private static final int MAX_STEP_PROGRESSION = 15;
    private static final int RESULT_PROGRESSION_LENGTH = 2;

    private static int[] progression(int firstElement, int step, int progressionLength) {
        int[] progression = new int[progressionLength];
        int element = firstElement;
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = element;
            element += step;
        }
        return progression;
    }

    private static String[] getProgressionWithHiddenElement(int[] progression, int indexHiddenElement) {
        StringBuilder resultProgression = new StringBuilder();
        String hiddenElement = null;
        String[] progressionAndHiddenElement = new String[RESULT_PROGRESSION_LENGTH];
        for (int i = 0; i < progression.length; i++) {
            int element = progression[i];
            if (i == indexHiddenElement) {
                hiddenElement = String.valueOf(element);
                resultProgression.append("..").append(" ");
            } else {
                resultProgression.append(element).append(" ");
            }
        }
        progressionAndHiddenElement[0] = resultProgression.toString();
        progressionAndHiddenElement[1] = hiddenElement;
        return progressionAndHiddenElement;
    }

    public static void start() {
        String[][] questionsAndAnswers = new String[QUESTION_AND_ANSWERS_ROWS][QUESTION_AND_ANSWERS_COLUMNS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstElement = Utils.generateRandomNumber(Engine.MAX_NUMBER);
            int step = Utils.generateRandomNumber(MIN_STEP_PROGRESSION, MAX_STEP_PROGRESSION);
            int progressionLength = Utils.generateRandomNumber(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
            int indexHiddenElement = Utils.generateRandomNumber(progressionLength);
            int[] progression = progression(firstElement, step, progressionLength);
            String[] progressionWithHiddenElement = getProgressionWithHiddenElement(progression, indexHiddenElement);
            questionsAndAnswers[0][i] = progressionWithHiddenElement[0];
            questionsAndAnswers[1][i] = progressionWithHiddenElement[1];
        }
        Engine.startGame(DESCRIPTION_GAME, questionsAndAnswers);
    }
}
