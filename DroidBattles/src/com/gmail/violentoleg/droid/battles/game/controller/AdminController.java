package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

public class AdminController {

    private ConsoleView consoleView;

    public AdminController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void showDroidDetails(String droidNumber) {
        consoleView.showMessage(droidNumber + " Droid: { some details}");
    }
}
