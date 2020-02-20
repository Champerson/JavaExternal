package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

public class DroidController {

    private ConsoleView consoleView;

    public DroidController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void showAllDroids() {
        consoleView.showMessage("All droids: d1, d2");
    }

    public void doFight(String firstDroidNumber, String secondDroidNumber) {
        consoleView.showMessage("...Fighting... " + firstDroidNumber + " has won");
    }
}
