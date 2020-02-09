package com.java.external.patterns.mvc.model;

import com.java.external.patterns.mvc.statistics.GameStatistics;

public class GameModel {

    private int leftBorder;
    private int rightBorder;
    private int guessNumber;
    private GameStatistics gameStatistics = new GameStatistics();

    public int getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(int leftBorder) {
        this.leftBorder = leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    public GameStatistics getGameStatistics() {
        return gameStatistics;
    }
}
