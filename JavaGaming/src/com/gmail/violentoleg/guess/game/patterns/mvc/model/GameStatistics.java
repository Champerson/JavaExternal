package com.gmail.violentoleg.guess.game.patterns.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class GameStatistics {
    
    private int numberOfInvalidInputs = 0;
    private int numberOfOutOfBorderInputs = 0;
    private int numberOfFailedAttempts = 0;
    private List<String> allUserInputs = new ArrayList<>();

    public void incrementNumberOfInvalidInputs() {
        this.numberOfInvalidInputs++;
    }

    public void incrementNumberOfOutOfBorderInputs() {
        this.numberOfOutOfBorderInputs++;
    }

    public void incrementNumberOfFailedAttempts() {
        this.numberOfFailedAttempts++;
    }

    public int getNumberOfInvalidInputs() {
        return numberOfInvalidInputs;
    }

    public int getNumberOfOutOfBorderInputs() {
        return numberOfOutOfBorderInputs;
    }

    public int getNumberOfFailedAttempts() {
        return numberOfFailedAttempts;
    }

    public void addUserInput(String userInput) {
        this.allUserInputs.add(userInput);
    }

    public List<String> getAllUserInputs() {
        return allUserInputs;
    }
}
