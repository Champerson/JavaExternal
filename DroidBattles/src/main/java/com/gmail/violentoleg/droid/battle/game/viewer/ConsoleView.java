package com.gmail.violentoleg.droid.battle.game.viewer;

public class ConsoleView {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String errorMessage) {
        System.err.println(errorMessage);
    }

    public void showLabel(String label) {
        System.out.print(label);
    }
}
