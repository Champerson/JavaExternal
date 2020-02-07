package com.java.external.game;


public class Game {

    private int leftBorder;
    private int rightBorder;
    private int guessNumber;
    private int attempts = 0;

    public Game(int range, int guessNumber) {
        this.guessNumber = guessNumber;
    }

    public Game() {

    }

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
}
