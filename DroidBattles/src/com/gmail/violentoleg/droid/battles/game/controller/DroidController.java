package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;
import com.gmail.violentoleg.droid.battles.game.viewer.DroidBattleViewer;

public class DroidController {

    private ConsoleView consoleView;
    private DroidBattleViewer viewer = new DroidBattleViewer();

    public DroidController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void startBattleOfTwoDroids(Droid firstFighter, Droid secondFighter) {
        int round = 1;
        viewer.printDroidBattleHeader(firstFighter, secondFighter);

        while (firstFighter.isAlive() && secondFighter.isAlive()) {
            viewer.printTitleOfRound(round++);
            firstFighter.giveDamage(secondFighter);
            if (secondFighter.isAlive()) {
                secondFighter.giveDamage(firstFighter);
            }
            viewer.printResultOfRound(firstFighter, secondFighter);
        }
    }

    public void showAllDroids() {
        consoleView.showMessage("All droids: d1, d2");
    }

    public void doFight(String firstDroidNumber, String secondDroidNumber) {
        consoleView.showMessage("...Fighting... " + firstDroidNumber + " has won");
    }
}
