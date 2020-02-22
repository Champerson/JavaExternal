package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.model.Duel;
import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;
import com.gmail.violentoleg.droid.battles.game.viewer.DroidViewer;

public class DroidController {

    private Duel duel;
    private ConsoleView consoleView;
    private DroidViewer viewer;

    public DroidController(ConsoleView consoleView/*, DroidViewer viewer, Duel duel*/) {
        this.consoleView = consoleView;
        //this.viewer = viewer;
        //this.duel = duel;
    }

    public void showAllDroids() {
        consoleView.showMessage("All droids: d1, d2");
    }

    public void doFight(String firstDroidNumber, String secondDroidNumber) {
        consoleView.showMessage("...Fighting... " + firstDroidNumber + " has won");
    }

    //SHOULD TO REFACTOR
    public void startDuel(Droid firstFighter, Droid secondFighter) {
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
}
