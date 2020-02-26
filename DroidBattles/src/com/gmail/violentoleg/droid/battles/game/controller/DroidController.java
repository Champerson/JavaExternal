package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.model.Duel;
import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;
import com.gmail.violentoleg.droid.battles.game.viewer.DroidViewer;

public class DroidController {

    private Duel duel;
    private DroidViewer viewer;
    private ConsoleView consoleView;

    public DroidController(ConsoleView consoleView, DroidViewer viewer) {
        this.consoleView = consoleView;
        this.viewer = viewer;
    }

    public void startDuel(Duel duel) {
        int round = 1;
        viewer.printDroidBattleHeader(duel.getFirstFighter(), duel.getSecondFighter());

        while (duel.getFirstFighter().isAlive() && duel.getSecondFighter().isAlive()) {
            viewer.printTitleOfRound(round++);
            duel.getFirstFighter().giveDamage(duel.getSecondFighter());
            if (duel.getSecondFighter().isAlive()) {
                duel.getSecondFighter().giveDamage(duel.getFirstFighter());
            }
            viewer.printResultOfRound(duel.getFirstFighter(), duel.getSecondFighter());
        }

        //viewer.printResultOfTheDuel(duel.getWinner());
    }
}
