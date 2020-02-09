package com.java.external.game;

public class GameViewer {

    private static final String ATTEMPTS_TITLE = "Total attempts: ";
    private static final String INVALID_INPUTS_TITLE = "Invalid inputs: ";
    private static final String ALL_INPUTS_TITLE = "All inputs during the game:" + System.lineSeparator();
    private static final String UNSUCCESSFUL_ATTEMPTS_TITLE = "Unsuccessful attempts: ";
    private static final String NUMBER_OUT_OF_BORDER_INPUTS_TITLE = "Out of border inputs: ";
    private static final String NUMBER_OUT_OF_RANGE_MESSAGE = "Your number in out of range.";
    private static final String AVAILABLE_SEARCH_RANGE_MESSAGE = "Available search range from ";
    private static final String CONGRATULATION_MESSAGE = "Congratulations, you won the game" + System.lineSeparator();
    private static final String INVALID_INTEGER_INPUT_MESSAGE = "Invalid type, please input an available integer value ";
    private static final String GAME_HEADER_MESSAGE = "Welcome to the guess the number game. " + System.lineSeparator() +
            "Input \"play\" to start or \'exit\' to exit the game. " + System.lineSeparator() +
            "Standard available range from 0 to 100.";

    public void printGameHeader() {
        System.out.println(GAME_HEADER_MESSAGE);
    }

    public void printAvailableSearchRange(GameModel gameModel) {
        System.out.println(AVAILABLE_SEARCH_RANGE_MESSAGE + gameModel.getLeftBorder() + " to " + gameModel.getRightBorder());
    }

    public void printOutOfBorderAttemptMessage() {
        System.out.println(NUMBER_OUT_OF_RANGE_MESSAGE);
    }

    public void printInvalidAttemptMessage() {
        System.out.println(INVALID_INTEGER_INPUT_MESSAGE);
    }

    public void printSuccessfulAttemptMessage(GameStatistics statistics) {
        System.out.println(CONGRATULATION_MESSAGE +
                ATTEMPTS_TITLE + statistics.getAllUserInputs().size() + System.lineSeparator() +
                INVALID_INPUTS_TITLE + statistics.getNumberOfInvalidInputs() + System.lineSeparator() +
                UNSUCCESSFUL_ATTEMPTS_TITLE + statistics.getNumberOfFailedAttempts() + System.lineSeparator() +
                NUMBER_OUT_OF_BORDER_INPUTS_TITLE + statistics.getNumberOfOutOfBorderInputs());
        printAllUserAttempts(statistics);
    }

    private void printAllUserAttempts(GameStatistics statistics) {
        System.out.print(ALL_INPUTS_TITLE);
        for (String attempt : statistics.getAllUserInputs()) {
            System.out.println(attempt);
        }
    }
}
