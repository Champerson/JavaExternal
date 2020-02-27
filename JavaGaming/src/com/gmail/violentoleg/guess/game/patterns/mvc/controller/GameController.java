package com.gmail.violentoleg.guess.game.patterns.mvc.controller;

import com.gmail.violentoleg.guess.game.patterns.mvc.model.GameModel;
import com.gmail.violentoleg.guess.game.patterns.mvc.model.GameStatistics;
import com.gmail.violentoleg.guess.game.patterns.mvc.viewer.GameViewer;

import java.util.Scanner;

import static java.lang.String.format;

public class GameController {

    private static final int INITIAL_LEFT_BORDER = 0;
    private static final int INITIAL_RIGHT_BORDER = 100;

    Scanner userInputScanner = new Scanner(System.in);
    private GameViewer gameViewer = new GameViewer();
    private GameMessagesController gameMessagesController = new GameMessagesController(gameViewer);

    public void play() {
        Scanner inputScanner = new Scanner(System.in);
        chooseLanguage();
        gameViewer.showMessage(gameMessagesController.getProperty("menu.header.message"));

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
            gameViewer.showError(gameMessagesController.getProperty("error.invalid.input"));
            return userDecideToPlay(inputScanner);
        }
    }


    private void startGame(Scanner inputScanner) {
        GameModel gameModel = initializeGameSettings();
        boolean gameOver = false;
        while (!gameOver) {
            gameViewer.showMessage(format(gameMessagesController.getProperty("game.available.range.message"), gameModel.getLeftBorder(), gameModel.getRightBorder()));
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
            gameViewer.showLabel(gameMessagesController.getProperty("game.invalid.attempt.message"));
            return false;
        } else {
            return true;
        }
    }

    private boolean checkUserAttemptIsSuccessful(int inputNumber, GameModel gameModel) {
        boolean successAttempt = false;
        if (inputNumber <= gameModel.getLeftBorder() || inputNumber >= gameModel.getRightBorder()) {
            gameModel.getGameStatistics().incrementNumberOfOutOfBorderInputs();
            gameViewer.showMessage(gameMessagesController.getProperty("game.out.of.border.attempt"));
        } else if (inputNumber < gameModel.getGuessNumber()) {
            gameModel.getGameStatistics().incrementNumberOfFailedAttempts();
            gameModel.setLeftBorder(inputNumber);
        } else if (inputNumber > gameModel.getGuessNumber()) {
            gameModel.getGameStatistics().incrementNumberOfFailedAttempts();
            gameModel.setRightBorder(inputNumber);
        } else if (inputNumber == gameModel.getGuessNumber()) {
            gameViewer.showMessage(format(gameMessagesController.getProperty("game.successful.attempt.message"),
                    gameModel.getGameStatistics().getAllUserInputs().size(),
                    gameModel.getGameStatistics().getNumberOfInvalidInputs(),
                    gameModel.getGameStatistics().getNumberOfFailedAttempts(),
                    gameModel.getGameStatistics().getNumberOfOutOfBorderInputs()));
            getAllUserAttempts(gameModel.getGameStatistics());
            successAttempt = true;
        }
        return successAttempt;
    }

    private void getAllUserAttempts(GameStatistics statistics) {
        gameViewer.showMessage(gameMessagesController.getProperty("game.all.user.inputs.title"));
        for (String attempt : statistics.getAllUserInputs()) {
            gameViewer.showMessage(attempt);
        }
    }

    private void chooseLanguage() {
        gameViewer.showMessage(gameMessagesController.getProperty("header.choose.language.label"));
        String userInput = userInputScanner.nextLine();
        if (userInput.equals("uk") || userInput.equals("en")) {
            gameMessagesController.changeLanguage(userInput);
        } else {
            chooseLanguage();
        }
    }
}

