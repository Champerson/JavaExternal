package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.viewer.DroidBattleViewer;

public class Battle {

    DroidBattleViewer viewer = new DroidBattleViewer();
    private Droid firstFighter;
    private Droid secondFighter;


    public Battle(Droid firstFighter, Droid secondFighter) {
        this.firstFighter = firstFighter;
        this.secondFighter = secondFighter;
    }

    public void startBattleOfTwoDroids() {
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
