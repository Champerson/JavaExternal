package com.java.external.patterns.mvc.controller;

import com.java.external.patterns.mvc.model.GameModel;
import com.java.external.patterns.mvc.viewer.GameViewer;

import java.util.Scanner;

public class GameController {

    private static final int INITIAL_LEFT_BORDER = 0;
    private static final int INITIAL_RIGHT_BORDER = 100;

    private GameViewer gameViewer = new GameViewer();

    public void play() {
        gameViewer.printGameHeader();

        Scanner inputScanner = new Scanner(System.in);
        if (userDecideToPlay(inputScanner)) {
            startGame(inputScanner);
        }
    }

    private boolean userDecideToPlay(Scanner inputScanner) {
        String userInput = inputScanner.nextLine();
        if (userInput.equalsIgnoreCase("play")) {
            return true;
        } else if (userInput.equalsIgnoreCase("exit")) {
            return false;
        } else {
            gameViewer.printIncorrectUserDecisionMessage();
            return userDecideToPlay(inputScanner);
        }
    }



    private void startGame(Scanner inputScanner) {
        GameModel gameModel = initializeGameSettings();
        boolean gameOver = false;
        while (!gameOver) {
            gameViewer.printAvailableSearchRange(gameModel);
            if (userInputIsValidInteger(inputScanner)) {
                String userInput = inputScanner.nextLine();
                int inputNumber = Integer.parseInt(userInput);
                gameModel.getGameStatistics().addUserInput(userInput);
                if (checkUserAttemptIsSuccessful(inputNumber, gameModel)) {
                    inputScanner.close();
                    gameOver = true;
                }
            } else {
                gameModel.getGameStatistics().incrementNumberOfInvalidInputs();
                gameModel.getGameStatistics().addUserInput(inputScanner.nextLine());
            }
        }
    }

    private GameModel initializeGameSettings() {
        int generatedGuessNumber = (int) (Math.random() * (INITIAL_RIGHT_BORDER - INITIAL_LEFT_BORDER) + INITIAL_LEFT_BORDER);
        GameModel gameModel = new GameModel();
        gameModel.setRightBorder(INITIAL_RIGHT_BORDER);
        gameModel.setLeftBorder(INITIAL_LEFT_BORDER);
        gameModel.setGuessNumber(generatedGuessNumber);
        return gameModel;
    }

    private boolean userInputIsValidInteger(Scanner scan) {
        if (!scan.hasNextInt()) {
            gameViewer.printInvalidAttemptMessage();
            return false;
        } else {
            return true;
        }
    }

    private boolean checkUserAttemptIsSuccessful(int inputNumber, GameModel gameModel) {
        boolean successAttempt = false;
        if (inputNumber <= gameModel.getLeftBorder() || inputNumber >= gameModel.getRightBorder()) {
            gameModel.getGameStatistics().incrementNumberOfOutOfBorderInputs();
            gameViewer.printOutOfBorderAttemptMessage();
        } else if (inputNumber < gameModel.getGuessNumber()) {
            gameModel.getGameStatistics().incrementNumberOfFailedAttempts();
            gameModel.setLeftBorder(inputNumber);
        } else if (inputNumber > gameModel.getGuessNumber()) {
            gameModel.getGameStatistics().incrementNumberOfFailedAttempts();
            gameModel.setRightBorder(inputNumber);
        } else if (inputNumber == gameModel.getGuessNumber()) {
            gameViewer.printSuccessfulAttemptMessage(gameModel.getGameStatistics());
            successAttempt = true;
        }
        return successAttempt;
    }
}

