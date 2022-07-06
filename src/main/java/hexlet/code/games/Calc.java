package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.QUESTION_AND_ANSWERS_COLUMNS;
import static hexlet.code.Engine.QUESTION_AND_ANSWERS_ROWS;

public class Calc {
    private static final String DESCRIPTION_GAME = "What is the result of the expression?";
    private static final int MAX_NUMBER = 20;
    private static final char[] OPERATIONS = {'+', '-', '*'};

    private static int calculateSum(int firstNumber, int secondNumber, char operation) {
        int result;
        if (operation == OPERATIONS[0]) {
            result = firstNumber + secondNumber;
        } else if (operation == OPERATIONS[1]) {
            result = firstNumber - secondNumber;
        } else {
            result = firstNumber * secondNumber;
        }
        return result;
    }

    public static void start() {
        String[][] questionsAndAnswers = new String[QUESTION_AND_ANSWERS_ROWS][QUESTION_AND_ANSWERS_COLUMNS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstNumber = Utils.generateRandomNumber(MAX_NUMBER);
            int secondNumber = Utils.generateRandomNumber(MAX_NUMBER);
            char operation = OPERATIONS[Utils.generateRandomNumber(OPERATIONS.length)];
            int result = calculateSum(firstNumber, secondNumber, operation);
            questionsAndAnswers[0][i] = firstNumber + " " + operation + " " + secondNumber;
            questionsAndAnswers[1][i] = Integer.toString(result);
        }
        Engine.startGame(DESCRIPTION_GAME, questionsAndAnswers);
    }
}
