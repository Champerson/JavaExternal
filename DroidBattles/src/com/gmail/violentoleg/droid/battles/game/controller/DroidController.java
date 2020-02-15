package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.model.*;
import com.gmail.violentoleg.droid.battles.game.viewer.DroidBattleViewer;

public class DroidController {

    private DroidBattleViewer viewer = new DroidBattleViewer();

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
}
