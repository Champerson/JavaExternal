package com.gmail.violentoleg.droid.battles.game.viewer;


import com.gmail.violentoleg.droid.battles.game.model.Droid;

public class DroidBattleViewer {

    public void printDroidSpecification(Droid droid) {
        System.out.println(droid);
    }

    public void printDroidBattleHeader(Droid firstFighter, Droid secondFighter) {
        System.out.println("Participants of the battle: ");
        printDroidSpecification(firstFighter);
        printDroidSpecification(secondFighter);
        System.out.println("\n Let's start!!!");
    }

    public void printTitleOfRound(int round) {
        System.out.println("\nResult of the round " + round);
    }

    public void printResultOfRound(Droid firstFighter, Droid secondFighter) {
        System.out.println("First fighter HP: " + firstFighter.getHealth() + "\n" +
                "Second fighter HP: " + secondFighter.getHealth());
    }
}
