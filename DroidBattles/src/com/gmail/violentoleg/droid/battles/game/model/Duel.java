package com.gmail.violentoleg.droid.battles.game.model;

import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;

public class Duel {

    private int userBet;
    private Droid winner;
    private Droid firstFighter;
    private Droid secondFighter;

    public Duel() {

    }

    public Duel(Droid firstFighter, Droid secondFighter) {
        this.firstFighter = firstFighter;
        this.secondFighter = secondFighter;
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

    public int getUserBet() {
        return userBet;
    }

    public void setUserBet(int userBet) {
        this.userBet = userBet;
    }

    public Droid getWinner() {
        return winner;
    }

    public void setWinner(Droid winner) {
        this.winner = winner;
    }
}
