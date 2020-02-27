package com.gmail.violentoleg.guess.game.patterns.mvc.viewer;


public class GameViewer {

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
