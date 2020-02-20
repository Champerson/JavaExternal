package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.viewer.DroidBattleViewer;

import java.util.ArrayList;
import java.util.List;

//SHOULD REDO SHOULD REDO SHOULD REDO SHOULD REDO SHOULD REDO SHOULD REDO SHOULD REDO SHOULD REDO SHOULD REDO
public class BattleController {

    private DroidBattleViewer viewer = new DroidBattleViewer();
    private List<Droid> allFighters = new ArrayList<>();
    private int userDroidBet;
    private Droid firstFighter;
    private Droid secondFighter;
    private Droid winner;

    public BattleController() {

    }

    //SHOULD REDO
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

    //SHOULD REDO
    public void watchListOfAvailableFighters() {
        int droidNumber = 1;

        for (Droid droid : allFighters) {
            System.out.println(droidNumber + " - " + droid.toString());
            droidNumber++;
        }
    }

    public List<Droid> getAllFighters() {
        return allFighters;
    }

    public int getUserDroidBet() {
        return userDroidBet;
    }

    public void setDroidUserBet(int userDroidRate) {
        this.userDroidBet = userDroidRate;
    }

    public Droid getFirstFighter() {
        return firstFighter;
    }

    public void setFirstFighter(Droid firstFighter) {
        this.firstFighter = firstFighter;
    }

    public Droid getSecondFighter() {
        return secondFighter;
    }

    public void setSecondFighter(Droid secondFighter) {
        this.secondFighter = secondFighter;
    }

    public Droid getWinner() {
        return winner;
    }

    public void setWinner(Droid winner) {
        this.winner = winner;
    }
}
